package com.iycc.pattern.observer.simple;

/**
 * 被观察的对象
 * Created by iycc on 2018/3/20.
 */
public interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String str);
}
