package com.j.u.r.lock;

import com.j.u.r.entity.AbstractEntity;
import com.j.u.r.keys.Keys;

public class LockEntity extends AbstractEntity {
    private String id;
    private long version;

    @Override
    public Keys uniqueKey() {
        return Keys.build(id);
    }
}
