package com.iycc.pattern.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by iycc on 2018/3/11.
 */
public class CglibProxySubject implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        // 设置要代理的目标类
        enhancer.setSuperclass(clazz);
        // 设置要代理的拦截器
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("pre do..");
        methodProxy.invokeSuper(o, objects);
        System.out.println("post do..");
        return null;

    }
}
