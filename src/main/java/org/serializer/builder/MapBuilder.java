package org.serializer.builder;

import org.serializer.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapBuilder implements Builder {
    private final List<Item<?>> entry = new ArrayList<>();
    private final MapItem mapItem = new MapItem();
    Builder parent;

    public MapBuilder(Builder parent) {
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

    public Builder addEntry(String key) {
        add(toItem(key));
        return this;
    }

    public Builder add(Item<?> item) {
        if (entry.isEmpty() && item.getValue().getClass() == String.class) {
            entry.add(item);
        } else if (!entry.isEmpty()) {
            entry.add(item);
            mapItem.setValue(Map.entry(entry.get(0), entry.get(1)));
        }
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

    public MapBuilder addMap() {
        return new MapBuilder(this);
    }

    @Override
    public Map<Item<?>, Item<?>> build() {
        return mapItem.getValue();
    }

    @Override
    public Builder end() {
        return parent.add(mapItem);
    }

    @Override
    public Builder endEntry() {
        entry.clear();
        return this;
    }
}
