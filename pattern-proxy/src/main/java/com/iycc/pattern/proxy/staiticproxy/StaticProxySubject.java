package com.iycc.pattern.proxy.staiticproxy;

import com.iycc.pattern.proxy.bean.RealSubject;
import com.iycc.pattern.proxy.bean.Subject;

/**
 * 静态代理类。Subject接口增加一个方法，该类就要手动实现一个方法
 * Created by iycc on 2018/3/11.
 */
public class StaticProxySubject implements Subject {
    private RealSubject realSubject;
    public StaticProxySubject(RealSubject realSubject){
        this.realSubject = realSubject;
    }

    @Override
    public void doOne() {
        System.out.println("pre do..");
        realSubject.doOne();
        System.out.println("post do..");
    }

    @Override
    public void doTwo() {
        System.out.println("pre do..");
        realSubject.doTwo();
        System.out.println("post do..");
    }
}
