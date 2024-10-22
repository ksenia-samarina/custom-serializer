package org.serializer.model;

import org.serializer.datastream.InputStream;
import org.serializer.datastream.OutputStream;

public interface Item<T> {
    void encode(OutputStream out);

    default <Y> Y decode(InputStream in) {
        return null;
    }

    default T decodeShort(InputStream in) {
        return null;
    }

    T getValue();

    void setValue(T value);
}
