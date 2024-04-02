package com.j.u.r.context;

import com.j.u.r.storage.TSO;
import lombok.Getter;

@Getter
public class Context {
    private TSO tso = new TSO();
}
