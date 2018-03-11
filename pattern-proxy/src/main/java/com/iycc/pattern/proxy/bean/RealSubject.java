package com.iycc.pattern.proxy.bean;

/**
 * Created by iycc on 2018/3/11.
 */
public class RealSubject implements Subject {
    @Override
    public void doOne() {
        System.out.println("realSubject doOne ...");
    }

    @Override
    public void doTwo() {
        System.out.println("realSubject doTwo ...");
    }
}
