package org.serializer.serialization;

import org.serializer.datastream.InputStream;
import org.serializer.model.*;

import java.util.ArrayList;
import java.util.List;

public class SerializerDecoder implements Decoder {

    private final InputStream inputStream;

    public SerializerDecoder(InputStream stream) {
        inputStream = stream;
    }

    @Override
    public List<?> decode() {
        List<Object> payloadArray = new ArrayList<>();

        while (inputStream.hasNextElement() && !inputStream.hasNextTerminalElement()) {
            int type = inputStream.read();
            Item<?> item = null;
            if (type == Type.BOOLEAN.getValue()) {
                item = new BooleanItem();
            } else if (type == Type.INTEGER.getValue()) {
                item = new IntegerItem();
            } else if (type == Type.LONG.getValue()) {
                item = new LongItem();
            } else if (type == Type.SHORT_STRING.getValue()) {
                item = new StringItem();
                payloadArray.add(item.decodeShort(inputStream));
                continue;
            } else if (type == Type.STRING.getValue()) {
                item = new StringItem();
                payloadArray.add(item.decode(inputStream));
                continue;
            } else if (type == Type.LIST.getValue()) {
                item = new ArrayItem();
            } else if (type == Type.MAP.getValue()) {
                item = new MapItem();
            }
            assert item != null;
            payloadArray.add(item.decode(inputStream));
        }
        return payloadArray;
    }
}
