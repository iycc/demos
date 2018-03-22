package com.iycc.pattern.observer.jdk;

import java.util.Observable;

/**
 * 被观察对象 - 特报员 继承 java.util.Observable
 * Created by iycc on 2018/3/20.
 */
public class SpecialReporter extends Observable {
    public void getNewNews(String msg){
        this.setChanged();
        this.notifyObservers(msg);
    }
}
