package com.j.u.r.keys;

import java.util.Arrays;

public class Keys {
    private Object[] keys;

    public Keys(Object[] keys) {
        this.keys = keys;
    }

    public static Keys build(Object... obj) {
        Object[] objects = new Object[obj.length];
        Keys keys1 = new Keys(objects);
        System.arraycopy(obj, 0, objects, 0, obj.length);
        return keys1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Keys keys1 = (Keys) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(keys, keys1.keys);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(keys);
    }
}
