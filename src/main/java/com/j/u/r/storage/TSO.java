package com.j.u.r.storage;

import com.j.u.r.entity.AbstractEntity;
import com.j.u.r.keys.Keys;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TSO {
    private Map<Object, Map<Keys, OpEntity>> data = new HashMap<>();

    public <E extends AbstractEntity> void addInsert(Object table, E entity) {
        Map<Keys, OpEntity> entityMap = data.computeIfAbsent(table, (k) -> new LinkedHashMap<>());
        Keys keys = entity.uniqueKey();
        OpEntity opEntity = new OpEntity(entity, Operator.INSERT);
        OpEntity old = entityMap.put(keys, opEntity);
        if (old == null) {
            return;
        }
        if (old.getOperator() == Operator.DELETE) {
            opEntity.setOperator(Operator.UPDATE);
            return;
        }
        throw new IllegalStateException("insert twice!");
    }

    public <E extends AbstractEntity> void addUpdate(Object table, E entity) {
        Map<Keys, OpEntity> entityMap = data.computeIfAbsent(table, (k) -> new LinkedHashMap<>());
        Keys keys = entity.uniqueKey();
        OpEntity opEntity = new OpEntity(entity, Operator.UPDATE);
        OpEntity old = entityMap.put(keys, opEntity);
        if (old == null) {
            return;
        }
        switch (old.getOperator()) {
            case DELETE:
                throw new IllegalStateException("update after delete!");
            case INSERT:
                opEntity.setOperator(Operator.INSERT);
                break;
        }
    }

    public <E extends AbstractEntity> void addDelete(Object table, E entity) {
        Map<Keys, OpEntity> entityMap = data.computeIfAbsent(table, (k) -> new LinkedHashMap<>());
        Keys keys = entity.uniqueKey();
        OpEntity opEntity = new OpEntity(entity, Operator.DELETE);
        OpEntity old = entityMap.put(keys, opEntity);
        if (old == null) {
            return;
        }
        switch (old.getOperator()) {
            case INSERT:
                entityMap.remove(keys);
                break;
        }
    }
}
