package com.j.u.r.storage;

import com.j.u.r.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
public class OpEntity {
    private AbstractEntity entity;
    @Setter
    private Operator operator;

    public OpEntity(AbstractEntity entity, Operator operator) {
        this.entity = entity;
        this.operator = operator;
    }
}
