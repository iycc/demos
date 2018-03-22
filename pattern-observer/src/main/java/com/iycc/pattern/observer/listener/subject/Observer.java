package com.iycc.pattern.observer.listener.subject;

import com.iycc.pattern.observer.listener.core.Event;

/**
 * 观察者
 * Created by iycc on 2018/3/21.
 */
public class Observer {

    public void advice(Event e){
        System.out.println("=========触发事件，打印日志========\n" + e);
    }

}
