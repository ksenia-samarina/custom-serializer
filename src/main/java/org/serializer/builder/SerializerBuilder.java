package org.serializer.builder;

import org.serializer.model.*;

import java.util.ArrayList;
import java.util.List;

public class SerializerBuilder implements Builder {

    private final List<Item<?>> items = new ArrayList<>();

    private Item<Integer> toItem(Integer payload) {
        IntegerItem item = new IntegerItem();
        item.setValue(payload);
        return item;
    }

    private Item<Long> toItem(Long payload) {
        LongItem item = new LongItem();
        item.setValue(payload);
        return item;
    }

    private Item<Boolean> toItem(Boolean payload) {
        BooleanItem item = new BooleanItem();
        item.setValue(payload);
        return item;
    }

    private Item<String> toItem(String payload) {
        StringItem item = new StringItem();
        item.setValue(payload);
        return item;
    }

    public Builder add(Item<?> item) {
        items.add(item);
        return this;
    }

    @Override
    public Builder add(Integer payload) {
        items.add(toItem(payload));
        return this;
    }

    @Override
    public Builder add(Long payload) {
        items.add(toItem(payload));
        return this;
    }

    @Override
    public Builder add(Boolean payload) {
        items.add(toItem(payload));
        return this;
    }

    @Override
    public Builder add(String payload) {
        items.add(toItem(payload));
        return this;
    }

    public ArrayBuilder addArray() {
        return new ArrayBuilder(this);
    }

    public MapBuilder addMap() {
        return new MapBuilder(this);
    }

    @Override
    public List<Item<?>> build() {
        return items;
    }
}
