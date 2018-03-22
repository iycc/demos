package com.iycc.pattern.observer.simple;

/**
 * 具体的观察者
 * Created by iycc on 2018/3/20.
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update(String str) {
        System.out.println(str);
    }
}
