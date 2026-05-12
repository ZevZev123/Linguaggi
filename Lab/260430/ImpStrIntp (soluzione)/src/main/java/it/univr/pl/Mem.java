package it.univr.pl;

import it.univr.pl.value.ExpValue;
import java.util.HashMap;
import java.util.Map;

public class Mem {

    private final Map<String, ExpValue<?>> values;

    public Mem() { values = new HashMap<>(); }

    public Mem(Mem mem) { values = new HashMap<>(mem.values); }

    public boolean contains(String id) {
        return values.containsKey(id);
    }

    public ExpValue<?> getValue(String id) {
        return values.get(id);
    }

    public void updateValue(String id, ExpValue<?> v) {
        values.put(id, v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (String var : values.keySet())
            sb.append(var).append(":").append(values.get(var)).append(" ");
        sb.append("}");
        return sb.toString();
    }
}