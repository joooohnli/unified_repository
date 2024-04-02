package com.j.u.r.context;

public class ContextHolder {
    private static final ThreadLocal<Context> threadLocal = new ThreadLocal<>();

    public static void init(Context context) {
        threadLocal.set(context);
    }

    public static void init() {
        init(new Context());
    }

    public static Context get() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
