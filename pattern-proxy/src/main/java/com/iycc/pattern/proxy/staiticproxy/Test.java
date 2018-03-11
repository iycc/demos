package com.iycc.pattern.proxy.staiticproxy;

import com.iycc.pattern.proxy.bean.RealSubject;

/**
 * Created by iycc on 2018/3/11.
 */
public class Test {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        StaticProxySubject staticProxySubject = new StaticProxySubject(realSubject);
        staticProxySubject.doOne();
    }
}
