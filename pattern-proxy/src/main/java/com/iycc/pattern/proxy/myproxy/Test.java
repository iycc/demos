package com.iycc.pattern.proxy.myproxy;

import com.iycc.pattern.proxy.bean.RealSubject;
import com.iycc.pattern.proxy.bean.Subject;

/**
 * Created by iycc on 2018/3/11.
 */
public class Test {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        MyProxySubject myProxySubject = new MyProxySubject(realSubject);
        Subject subject = (Subject) myProxySubject.getProxyInstance();
        System.out.println(subject.getClass());
        subject.doOne();
        subject.doTwo();
    }
}
