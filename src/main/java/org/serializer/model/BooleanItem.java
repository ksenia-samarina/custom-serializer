package org.serializer.model;

import org.serializer.datastream.InputStream;
import org.serializer.datastream.OutputStream;

public class BooleanItem implements Item<Boolean>{
    private static final Type type = Type.BOOLEAN;
    private Boolean value;

    public BooleanItem(Boolean payload) {
        value = payload;
    }

    public BooleanItem() {
    }


    @Override
    public void encode(OutputStream out) {
        out.write((byte) type.getValue());
        out.write((byte) (value ? 1 : 0));
    }

    @Override
    public Boolean decode(InputStream in) {
        return in.read() == (byte) 1;
    }

    public void setValue(Boolean payload) {
        value = payload;
    }

    public Boolean getValue() {
        return value;
    }
}
