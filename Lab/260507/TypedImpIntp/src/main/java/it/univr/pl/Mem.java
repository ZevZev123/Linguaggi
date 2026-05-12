package it.univr.pl;

import it.univr.pl.type.ExpType;
import it.univr.pl.type.SimpleType;
import it.univr.pl.value.*;
import java.util.HashMap;
import java.util.Map;

public class Mem {

    private final Map<String, ExpValue<?>> values = new HashMap<>();
    private final Map<String, ExpType> types = new HashMap<>();

    public boolean contains(String id) {
        return values.containsKey(id) && values.get(id) != null;
    }

    public ExpValue<?> getValue(String id) {
        return values.get(id);
    }

    public ExpType getType(String id) {
        return types.get(id);
    }

    public void updateValue(String id, ExpValue<?> v) { values.put(id, v); }

    public void add(String id, ExpValue<?> v) {
        values.put(id, v);

        if (v instanceof BoolValue)
            types.put(id, SimpleType.BOOL);
        if (v instanceof IntValue)
            types.put(id, SimpleType.INT);
        if (v instanceof DecValue)
            types.put(id, SimpleType.DEC);
        if (v instanceof StringValue)
            types.put(id, SimpleType.STRING);
    }

    public void add(String id, ExpType t) {
        values.put(id, null);
        types.put(id, t);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (String var : values.keySet())
            sb.append(var).append("[").append(types.get(var).getName()).append("]:").append(values.get(var)).append(" ");
        sb.append("}");
        return sb.toString();
    }
}
