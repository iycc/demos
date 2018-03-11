package com.iycc.pattern.proxy.myproxy.core;

import java.lang.reflect.Method;

/**
 * Created by iycc on 2018/3/11.
 */
public interface MyInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable ;
}
