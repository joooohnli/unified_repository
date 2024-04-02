package com.j.u.r.api;

import com.j.u.r.cache.QEMapping;
import com.j.u.r.entity.AbstractEntity;

import java.util.List;

public interface TableOperation<E extends AbstractEntity, Q> {
    void insert(E entity);

    void update(E entity);

    void delete(E entity);

    List<E> select(Q query);

    QEMapping<Q, E> defQEMapping(Q q, E e);

}
