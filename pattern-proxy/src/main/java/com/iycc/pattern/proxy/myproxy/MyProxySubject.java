package com.iycc.pattern.proxy.myproxy;

import com.iycc.pattern.proxy.bean.Subject;
import com.iycc.pattern.proxy.myproxy.core.MyClassLoader;
import com.iycc.pattern.proxy.myproxy.core.MyInvocationHandler;
import com.iycc.pattern.proxy.myproxy.core.MyProxy;

import java.lang.reflect.Method;

/**
 * 仿JDK动态代理，实现自定义动态代理
 * Created by iycc on 2018/3/11.
 */
public class MyProxySubject implements MyInvocationHandler {
    private Subject subject;

    public MyProxySubject(Subject subject){
        this.subject = subject;
    }

    public Object getProxyInstance() {
        return MyProxy.newProxyInstance(new MyClassLoader() ,this.subject.getClass().getInterfaces(),this);
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
