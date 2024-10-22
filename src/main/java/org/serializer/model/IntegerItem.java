package org.serializer.model;

import org.serializer.datastream.InputStream;
import org.serializer.datastream.OutputStream;

public class IntegerItem implements Item<Integer>{
    private static final Type type = Type.INTEGER;
    private Integer value;

    public static int encodeZigZag(final int n) {
        return (n << 1) ^ (n >> 31);
    }

    public static int decodeZigZag(final int n) {
        return (n >>> 1) ^ -(n & 1);
    }

    public IntegerItem(Integer payload) {
        value = payload;
    }

    public IntegerItem() {
    }

    @Override
    public void encode(OutputStream out) {
        out.write((byte) type.getValue());
        encodeVarint(out, encodeZigZag(value));
    }

    public void encodeVarint(OutputStream out, Integer value) {
        while (true) {
            if ((value & ~0x7F) == 0) {
                out.write(value.byteValue());
                return;
            } else {
                out.write((byte) ((value & 0x7F) | 0x80));
                value >>>= 7;
            }
        }
    }

    @Override
    public Integer decode(InputStream in) {
        return decodeZigZag(decodeVarint(in));
    }

    public Integer decodeVarint(InputStream in) {
        int shift = 0;
        int result = 0;
        while (shift < 32) {
            final byte b = in.read();
            result |= (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        return null;
    }

    public void setValue(Integer payload) {
        value = payload;
    }

    public Integer getValue() {
        return value;
    }
}
