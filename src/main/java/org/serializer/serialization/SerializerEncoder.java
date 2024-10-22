package org.serializer.serialization;

import org.serializer.datastream.OutputStream;
import org.serializer.model.Item;

import java.util.List;

public class SerializerEncoder implements Encoder {

    private final OutputStream outputStream;

    public SerializerEncoder(OutputStream stream) {
        outputStream = stream;
    }

    @Override
    public void encode(List<Item<?>> items) {
        for (Item<?> item : items) {
            encodeNext(item);
        }
    }

    private void encodeNext(Item<?> item) {
        item.encode(outputStream);
    }


}
