package com.iycc.pattern.observer.simple;

/**
 * Created by iycc on 2018/3/20.
 */
public class Test {
    public static void main(String[] args) {
        Subject girl = new ConcreteSubject(); // 被观察对象
        // 三个观察者
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        Observer observer3 = new ConcreteObserver();
        // 添加观察者
        girl.addObserver(observer1);
        girl.addObserver(observer2);
        girl.addObserver(observer3);
        // 通知所有观察者
        girl.notifyObservers("hello");
        // 移除一个观察者
        girl.removeObserver(observer2);
        // 通知所有观察者
        girl.notifyObservers("呵呵");
    }
}
