package org.serializer.datastream;

public interface InputStream {
    byte read();

    byte[] readBytes();

    boolean hasNextElement();

    boolean hasNextTerminalElement();
}
