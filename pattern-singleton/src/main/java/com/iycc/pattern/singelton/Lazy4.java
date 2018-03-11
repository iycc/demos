package com.iycc.pattern.singelton;

/**
 * 懒汉式单例 - 静态内部类方式
 * Created by iycc on 2018/3/11.
 */
public class Lazy4 {
    private static Lazy4 lazy4 = null;

    private Lazy4() {
    }

    public static Lazy4 getInstance() {
        return Lazy4Holder.INSTANCE;
    }

    private static class Lazy4Holder {
        private static final Lazy4 INSTANCE = new Lazy4();
    }
}
