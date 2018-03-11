package com.iycc.pattern.proxy.jdkproxy;

import com.iycc.pattern.proxy.bean.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理。代理Subject接口的所有方法，Subject接口添加方法后，该类不需要修改。
 * Created by iycc on 2018/3/11.
 */
public class JdkProxySubject implements InvocationHandler {
    private Subject subject;

    public JdkProxySubject(Subject subject){
        this.subject = subject;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(this.subject.getClass().getClassLoader()
                ,this.subject.getClass().getInterfaces(),this);
    }

    /**
     * 被代理对象的所有方法，都会走该方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre do..");
        method.invoke(this.subject, args);
        System.out.println("post do..");
        return null;
    }
}
