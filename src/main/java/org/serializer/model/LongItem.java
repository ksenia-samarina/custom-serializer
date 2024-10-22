package org.serializer.model;

import org.serializer.datastream.InputStream;
import org.serializer.datastream.OutputStream;

public class LongItem implements Item<Long> {

    private static final Type type = Type.LONG;
    private Long value;

    public static long encodeZigZag(final long n) {
        return (n << 1) ^ (n >> 63);
    }

    public static long decodeZigZag(final long n) {
        return (n >>> 1) ^ -(n & 1);
    }

    public LongItem(Long payload) {
        value = payload;
    }

    public LongItem() {
    }

    @Override
    public void encode(OutputStream out) {
        out.write((byte) type.getValue());
        encodeVarint(out, encodeZigZag(value));
    }

    public void encodeVarint(OutputStream out, Long value) {
        while (true) {
            if ((value & ~0x7FL) == 0) {
                out.write(value.byteValue());
                return;
            } else {
                out.write((byte) ((value & 0x7F) | 0x80));
                value >>>= 7;
            }
        }
    }

    @Override
    public Long decode(InputStream in) {
        return decodeZigZag(decodeVarint(in));
    }

    public Long decodeVarint(InputStream in) {
        int shift = 0;
        long result = 0;
        while (shift < 64) {
            final byte b = in.read();
            result |= (long) (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        return null;
    }

    public void setValue(Long payload) {
        value = payload;
    }

    public Long getValue() {
        return value;
    }
}
