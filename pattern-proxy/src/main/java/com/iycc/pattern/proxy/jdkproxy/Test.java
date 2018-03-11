package com.iycc.pattern.proxy.jdkproxy;

import com.iycc.pattern.proxy.bean.RealSubject;
import com.iycc.pattern.proxy.bean.Subject;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by iycc on 2018/3/11.
 */
public class Test {
    public static void main(String[] args) {
        // 该设置用于输出jdk动态代理产生的类
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        RealSubject realSubject = new RealSubject();
        JdkProxySubject jdkProxySubject = new JdkProxySubject(realSubject);
        Subject subject = (Subject) jdkProxySubject.getProxyInstance();
        System.out.println(subject.getClass());
        subject.doOne();
        subject.doTwo();
        // 源码分析
        //generateProxyClass();
    }

    public static void generateProxyClass() {
        try {
            byte[] classFile = ProxyGenerator.generateProxyClass("TestProxyGen", RealSubject.class.getInterfaces());
            File file = new File("D:/TestProxyGen.class");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(classFile);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
