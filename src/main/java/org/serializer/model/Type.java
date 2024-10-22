package org.serializer.model;

public enum Type {
    BOOLEAN(0),
    INTEGER(1),
    LONG(2),
    SHORT_STRING(3),
    STRING(4),
    LIST(5),
    MAP(6),
    KEY(7),
    TERMINAL_ELEMENT(8);
    private final int value;

    Type(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
