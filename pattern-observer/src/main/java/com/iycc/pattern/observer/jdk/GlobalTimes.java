package com.iycc.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者 - 实现 java.util.Observer
 * Created by iycc on 2018/3/20.
 */
public class GlobalTimes extends NewspaperOffice implements Observer {
    private Observable observable;

    public GlobalTimes(SpecialReporter reporter){
        this.observable = reporter;
        reporter.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        if(o instanceof SpecialReporter){
            System.out.println("Global Timse brings you the latest news!");
        }
    }
}