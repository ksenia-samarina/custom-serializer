package org.serializer.serialization;

import org.serializer.model.Item;

import java.util.List;

public interface Encoder {
    void encode(List<Item<?>> items);
}
