package com.j.u.r.api;

import com.j.u.r.entity.AbstractEntity;

import java.util.List;

public interface Process {
    <E extends AbstractEntity, Q, T extends TableOperation<E, Q>> void addInsert(Class<T> tableOperation, E entity);

    <E extends AbstractEntity, Q, T extends TableOperation<E, Q>> void addUpdate(Class<T> tableOperation, E entity);

    <E extends AbstractEntity, Q, T extends TableOperation<E, Q>> void addDelete(Class<T> tableOperation, E entity);

    <E extends AbstractEntity, Q, T extends TableOperation<E, Q>> List<E> select(Class<T> tableOperation, Q query);
}
