package org.serializer.datastream;

import org.serializer.model.Type;

import java.util.ArrayList;
import java.util.List;

public class DataOutput implements OutputStream {
    private final List<Byte> bytes = new ArrayList<>();

    public void encodeVarint(Integer value) {
        while (true) {
            if ((value & ~0x7F) == 0) {
                write(value.byteValue());
                return;
            } else {
                write((byte) ((value & 0x7F) | 0x80));
                value >>>= 7;
            }
        }
    }

    @Override
    public void writeBytes(Type type, byte[] values) {
        write((byte) type.getValue());
        encodeVarint(values.length);
        for (byte b : values) {
            write(b);
        }
    }

    @Override
    public void write(byte value) {
        bytes.add(value);
    }

    @Override
    public List<Byte> toByteList() {
        return bytes;
    }
}
