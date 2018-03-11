package com.iycc.pattern.singelton;

import java.io.Serializable;

/**
 * 防止反序列化时，导致的单例破坏，重写readResolve方法
 * Created by iycc on 2018/3/11.
 */
public class SeriesDemo implements Serializable {
    public final static SeriesDemo INSTANCE = new SeriesDemo();

    private SeriesDemo() {
    }

    public static SeriesDemo getInstance() {
        return INSTANCE;
    }

    /**
     * 防止反序列化时，导致的单例破坏
     *
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }

}
