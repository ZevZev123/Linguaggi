package it.univr.pl.type;

import it.univr.pl.value.*;

public enum SimpleType implements ExpType {
    INT("int"),
    DEC("dec"),
    BOOL("bool"),
    STRING("string");

    private final String name;

    SimpleType(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    @Override
    public boolean isCompatible(Type type) {
        return this == type;
    }

    public static SimpleType fromString(String str) {
        return switch (str) {
            case "int" -> SimpleType.INT;
            case "dec" -> SimpleType.DEC;
            case "bool" -> SimpleType.BOOL;
            case "string" -> SimpleType.STRING;
            default -> null;
        };
    }

    public static SimpleType fromValue(ExpValue<?> value) {
        if (value instanceof IntValue)
            return SimpleType.INT;
        if (value instanceof DecValue)
            return SimpleType.DEC;
        if (value instanceof BoolValue)
            return SimpleType.BOOL;
        if (value instanceof StringValue)
            return SimpleType.STRING;

        return null;
    }
}
