package com.j.u.r.process;

import com.j.u.r.api.Process;
import com.j.u.r.api.TableOperation;
import com.j.u.r.context.ContextHolder;
import com.j.u.r.entity.AbstractEntity;

import java.util.List;

public class ProcessImpl implements Process {
    @Override
    public <E extends AbstractEntity, Q, T extends TableOperation<E, Q>> void addInsert(Class<T> tableOperation, E entity) {
        ContextHolder.get().getTso().addInsert(tableOperation, entity);
    }

    @Override
    public <E extends AbstractEntity, Q, T extends TableOperation<E, Q>> void addUpdate(Class<T> tableOperation, E entity) {
        ContextHolder.get().getTso().addUpdate(tableOperation, entity);
    }

    @Override
    public <E extends AbstractEntity, Q, T extends TableOperation<E, Q>> void addDelete(Class<T> tableOperation, E entity) {
        ContextHolder.get().getTso().addDelete(tableOperation, entity);
    }

    @Override
    public <E extends AbstractEntity, Q, T extends TableOperation<E, Q>> List<E> select(Class<T> tableOperation, Q query) {
        // todo 1. instance; 2. from cache
        TableOperation tableOperationInstance = null;
        return tableOperationInstance.select(query);
    }

}
