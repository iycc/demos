package com.iycc.pattern.observer.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的被观察对象
 * Created by iycc on 2018/3/20.
 */
public class ConcreteSubject implements Subject{
    private List<Observer> list = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers(String str) {
        for(Observer observer : list)
        {
            observer.update(str);
        }
    }
}
