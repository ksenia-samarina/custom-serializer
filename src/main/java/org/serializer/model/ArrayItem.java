package org.serializer.model;

import org.serializer.datastream.InputStream;
import org.serializer.datastream.OutputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArrayItem implements Item<List<Item<?>>> {
    private static final Type type = Type.LIST;

    private List<Item<?>> array = new ArrayList<>();

    public ArrayItem(List<Item<?>> payload) {
        array = payload;
    }

    public ArrayItem() {
    }

    @Override
    public void encode(OutputStream out) {
        out.write((byte) type.getValue());
        for (Item<?> item : array) {
            item.encode(out);
        }
        out.write((byte) Type.TERMINAL_ELEMENT.getValue());
    }

    @Override
    public List<Object> decode(InputStream in) {
        List<Object> payloadList = new ArrayList<>();
        while (!in.hasNextTerminalElement()) {
            int type = in.read();
            if (type == Type.BOOLEAN.getValue()) {
                Item<Boolean> item = new BooleanItem();
                Boolean payload = item.decode(in);
                payloadList.add(payload);
            } else if (type == Type.INTEGER.getValue()) {
                Item<Integer> item = new IntegerItem();
                Integer payload = item.decode(in);
                payloadList.add(payload);
            } else if (type == Type.LONG.getValue()) {
                Item<Long> item = new LongItem();
                Long payload = item.decode(in);
                payloadList.add(payload);
            } else if (type == Type.STRING.getValue()) {
                Item<String> item = new StringItem();
                String payload = item.decode(in);
                payloadList.add(payload);
            } else if (type == Type.SHORT_STRING.getValue()) {
                Item<String> item = new StringItem();
                String payload = item.decodeShort(in);
                payloadList.add(payload);
            } else if (type == Type.LIST.getValue()) {
                Item<List<Item<?>>> item = new ArrayItem();
                List<Object> payload = item.decode(in);
                payloadList.add(payload);
            } else if (type == Type.MAP.getValue()) {
                Item<Map<Item<?>, Item<?>>> item = new MapItem();
                Map<Object, Object> payload = item.decode(in);
                payloadList.add(payload);
            }
        }
        in.read();
        return payloadList;
    }

    @Override
    public List<Item<?>> getValue() {
        return array;
    }

    @Override
    public void setValue(List<Item<?>> itemList) {
        for (Item<?> item : itemList) {
            setValue(item);
        }
    }

    public void setValue(Item<?> value) {
        array.add(value);
    }
}
