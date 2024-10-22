package org.serializer.datastream;

import org.serializer.model.Type;

import java.util.List;

public interface OutputStream {
    void writeBytes(Type type, byte[] values);
    void write(byte value);
    List<Byte> toByteList();
}
