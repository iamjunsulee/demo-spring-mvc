package me.junsu.demospringmvc;

import java.util.HashMap;
import java.util.Map;

public class Header {
    private Map<String, Object> map;

    public Header() {
        map = new HashMap<>();
    }

    public void put(String key, String value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }
}
