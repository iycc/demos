package com.iycc.pattern.proxy.cglibproxy;

import com.iycc.pattern.proxy.bean.RealSubject;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * Created by iycc on 2018/3/11.
 */
public class Test {
    public static void main(String[] args) {
        // 该设置用于输出cglib动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");

        RealSubject realSubject = (RealSubject) new CglibProxySubject().getInstance(RealSubject.class);
        System.out.println(realSubject.getClass());
        realSubject.doOne();
    }
}
