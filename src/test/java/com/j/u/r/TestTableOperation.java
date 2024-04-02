package com.j.u.r;

import com.j.u.r.api.TableOperation;
import com.j.u.r.cache.QEMapping;
import com.j.u.r.entity.AbstractEntity;

public class TestTableOperation implements TableOperation<TestEntity, TestEntity.Query> {
    @Override
    public QEMapping<TestEntity.Query, TestEntity> defQEMapping(TestEntity.Query query, TestEntity testEntity) {
        QEMapping<TestEntity.Query, TestEntity>mapping = new QEMapping<>();
        mapping.addEq(q -> q.getId(), t -> t.getId());
        return mapping;
    }
}
