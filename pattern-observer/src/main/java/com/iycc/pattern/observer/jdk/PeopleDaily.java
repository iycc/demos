package com.iycc.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者 - 实现 java.util.Observer
 * Created by iycc on 2018/3/20.
 */
public class PeopleDaily extends NewspaperOffice implements Observer {
    private Observable observable;

    public PeopleDaily(SpecialReporter reporter){
        this.observable = reporter;
        reporter.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        if(o instanceof SpecialReporter){
            System.out.println("People's Daily brings you the latest news!");
        }
    }

    public void remove(){
        observable.deleteObserver(this);
    }
}  
