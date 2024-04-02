package com.j.u.r.cache;

import com.j.u.r.entity.AbstractEntity;

import java.util.List;
import java.util.Map;

public class LocalCache {
    private Map<Object, Map<Object, List<AbstractEntity>>> cache;
}
