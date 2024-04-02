package com.j.u.r;

import com.j.u.r.context.Context;
import com.j.u.r.context.ContextHolder;
import com.j.u.r.api.TableOperation;
import com.j.u.r.api.Process;
import com.j.u.r.process.ProcessImpl;
import com.j.u.r.storage.TSO;
import com.j.u.r.utils.Func1;

import java.util.List;

public class Repository {
    private Process process = new ProcessImpl();

    private List<TableOperation<?, ?>> tableOperations;

    public <R> R process(Func1<Process, R> func) {
        // todo necessary?
        ContextHolder.init();
        try{
            R r = func.run(process);
            Context context = ContextHolder.get();
            TSO tso = context.getTso();
            // todo save transaction

            return r;
        } finally {
            ContextHolder.clear();
        }
    }




}
