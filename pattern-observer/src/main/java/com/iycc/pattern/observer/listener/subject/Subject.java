package com.iycc.pattern.observer.listener.subject;

import com.iycc.pattern.observer.listener.core.EventListener;

/**
 * 被观察者，维护一个事件监听列表，触发某事件时，监听列表里如果有相应的事件则触发事件，如果没有就不触发
 * Created by iycc on 2018/3/21.
 */
public class Subject extends EventListener {

    //通常的话，采用动态代理来实现监控，避免了代码侵入
    public void add(){
        System.out.println("调用添加的方法");
        trigger(SubjectEventType.ON_ADD);
    }

    public void remove(){
        System.out.println("调用删除的方法");
        trigger(SubjectEventType.ON_REMOVE);
    }

}
