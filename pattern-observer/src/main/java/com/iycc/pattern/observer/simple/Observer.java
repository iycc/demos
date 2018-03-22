package com.iycc.pattern.observer.simple;

/**
 * 观察者
 * Created by iycc on 2018/3/20.
 */
public interface Observer {
    /**
     * 被观察对象的通知方法
     * @param str
     */
    void update(String str);
}
