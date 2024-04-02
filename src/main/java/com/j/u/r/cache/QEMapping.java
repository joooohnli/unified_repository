package com.j.u.r.cache;

import com.j.u.r.entity.AbstractEntity;
import com.j.u.r.utils.Func1;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QEMapping<Q, E extends AbstractEntity> {
    private final List<MatchEntry<?, ?>> matchEntries = new ArrayList<>();

    public void addEq(Func1<Q, Object> qFunc, Func1<E, Object> eFunc) {
        matchEntries.add(new MatchEntry<Q, E>(qFunc, eFunc));
    }

    public <E extends AbstractEntity, Q> boolean match(Q q, E e) {
        for (MatchEntry matchEntry : matchEntries) {
            boolean match = matchEntry.match(q, e);
            if (!match) {
                return false;
            }
        }
        return true;
    }


    @AllArgsConstructor
    public static class MatchEntry<Q, E> {
        private Func1<Q, Object> qFunc;
        private Func1<E, Object> eFunc;


        boolean match(Q q, E e) {
            return Objects.equals(qFunc.run(q), eFunc.run(e));
        }
    }
}
