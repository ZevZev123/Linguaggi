package it.univr.pl;

import it.univr.pl.value.ExpValue;

import java.util.HashMap;
import java.util.Map;

public class Mem {

    private final Map<String, ExpValue<?>> map = new HashMap<>();

    public boolean contains(String id) {
        return map.containsKey(id);
    }

    public ExpValue<?> get(String id) {
        return map.get(id);
    }

    public void update(String id, ExpValue<?> v) {
        map.put(id, v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (String var : map.keySet())
            sb.append(var).append(":").append(map.get(var)).append(" ");
        sb.append("}");
        return sb.toString();
    }
}