package org.serializer.model;

import org.serializer.datastream.InputStream;
import org.serializer.datastream.OutputStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapItem implements Item<Map<Item<?>, Item<?>>> {
    private static final Type type = Type.MAP;
    private static final Type key = Type.KEY;

    private Map<Item<?>, Item<?>> map = new HashMap<>();

    public MapItem(Map<Item<?>, Item<?>> payload) {
        map = payload;
    }

    public MapItem() {
    }

    @Override
    public void encode(OutputStream out) {
        out.write((byte) type.getValue());
        for (Map.Entry<Item<?>, Item<?>> item : map.entrySet()) {
            out.write((byte) key.getValue());
            item.getKey().encode(out);

            item.getValue().encode(out);
        }
        out.write((byte) Type.TERMINAL_ELEMENT.getValue());
    }

    @Override
    public Map<Object, Object> decode(InputStream in) {
        Map<Object, Object> payloadMap = new HashMap<>();
        String key = null;
        while (!in.hasNextTerminalElement()) {
            int type = in.read();
            if (type == Type.KEY.getValue()) {
                byte keyType = in.read();
                assert (keyType == Type.STRING.getValue()) || (keyType == Type.SHORT_STRING.getValue());
                Item<String> item = new StringItem();
                key = (keyType == Type.STRING.getValue()) ? item.decode(in) : item.decodeShort(in);
            } else if (type == Type.BOOLEAN.getValue()) {
                Item<Boolean> item = new BooleanItem();
                Boolean payload = item.decode(in);
                assert key != null;
                payloadMap.put(key, payload);
            } else if (type == Type.INTEGER.getValue()) {
                Item<Integer> item = new IntegerItem();
                Integer payload = item.decode(in);
                assert key != null;
                payloadMap.put(key, payload);
            } else if (type == Type.LONG.getValue()) {
                Item<Long> item = new LongItem();
                Long payload = item.decode(in);
                assert key != null;
                payloadMap.put(key, payload);
            } else if (type == Type.STRING.getValue()) {
                Item<String> item = new StringItem();
                String payload = item.decode(in);
                assert key != null;
                payloadMap.put(key, payload);
            } else if (type == Type.SHORT_STRING.getValue()) {
                Item<String> item = new StringItem();
                String payload = item.decodeShort(in);
                assert key != null;
                payloadMap.put(key, payload);
            } else if (type == Type.LIST.getValue()) {
                Item<List<Item<?>>> item = new ArrayItem();
                List<Object> payload = item.decode(in);
                assert key != null;
                payloadMap.put(key, payload);
            } else if (type == Type.MAP.getValue()) {
                Item<Map<Item<?>, Item<?>>> item = new MapItem();
                Map<Object, Object> payload = item.decode(in);
                assert key != null;
                payloadMap.put(key, payload);
            }
        }
        in.read();
        return payloadMap;
    }

    @Override
    public Map<Item<?>, Item<?>> getValue() {
        return map;
    }

    @Override
    public void setValue(Map<Item<?>, Item<?>> itemMap) {
        for (Map.Entry<Item<?>, Item<?>> item : itemMap.entrySet()) {
            setValue(item);
        }
    }

    public void setValue(Map.Entry<Item<?>, Item<?>> value) {
        map.put(value.getKey(), value.getValue());
    }
}
