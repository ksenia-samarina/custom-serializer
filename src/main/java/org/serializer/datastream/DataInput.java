package org.serializer.datastream;

import org.serializer.model.Type;

import java.util.List;

public class DataInput implements InputStream {
    private final List<Byte> bytes;
    private int index = -1;

    public DataInput(List<Byte> bytes) {
        this.bytes = bytes;
    }

    public Integer decodeVarint() {
        int shift = 0;
        int result = 0;
        while (shift < 32) {
            final byte b = read();
            result |= (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        return null;
    }

    @Override
    public byte[] readBytes() {
        int n = decodeVarint();
        byte[] bytes = new byte[n];
        for (int i = 0; i < n; i++) {
            bytes[i] = read();
        }
        return bytes;
    }

    @Override
    public byte read() {
        return bytes.get(++index);
    }

    @Override
    public boolean hasNextElement() {
        return index + 1 < bytes.size();
    }

    @Override
    public boolean hasNextTerminalElement() {
        return hasNextElement() && (bytes.get(index + 1) == Type.TERMINAL_ELEMENT.getValue());
    }
}
