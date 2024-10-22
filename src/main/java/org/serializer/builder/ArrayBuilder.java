package org.serializer.builder;

import org.serializer.model.*;

import java.util.ArrayList;
import java.util.List;

public class ArrayBuilder implements Builder {
    private final List<Item<?>> items = new ArrayList<>();
    private final ArrayItem arrayItem = new ArrayItem();
    Builder parent;

    public ArrayBuilder(Builder parent) {
        this.parent = parent;
    }

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
        arrayItem.setValue(item);
        return this;
    }

    @Override
    public Builder add(Integer payload) {
        add(toItem(payload));
        return this;
    }

    @Override
    public Builder add(Long payload) {
        add(toItem(payload));
        return this;
    }

    @Override
    public Builder add(Boolean payload) {
        add(toItem(payload));
        return this;
    }

    @Override
    public Builder add(String payload) {
        add(toItem(payload));
        return this;
    }

    public ArrayBuilder addArray() {
        return new ArrayBuilder(this);
    }

    @Override
    public Builder addMap() {
        return new MapBuilder(this);
    }

    @Override
    public List<Item<?>> build() {
        items.add(arrayItem);
        return items;
    }

    @Override
    public Builder end() {
        return parent.add(arrayItem);
    }
}
