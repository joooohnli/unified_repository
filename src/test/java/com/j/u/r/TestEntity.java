package com.j.u.r;

import com.j.u.r.entity.AbstractEntity;
import com.j.u.r.keys.Keys;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestEntity extends AbstractEntity {
    private long id;
    private String name;
    private long version;
    @Override
    public Keys uniqueKey() {
        return null;
    }

    @Getter
    @Setter
    public static class Query {
        private long id;
    }
}
