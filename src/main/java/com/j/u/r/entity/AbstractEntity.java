package com.j.u.r.entity;

import com.j.u.r.keys.Keys;

public abstract class AbstractEntity {
    private Long oldVersion;

    public abstract Keys uniqueKey();
}
