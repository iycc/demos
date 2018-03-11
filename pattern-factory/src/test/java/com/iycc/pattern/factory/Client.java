package com.iycc.pattern.factory;

import com.iycc.pattern.factory.abstractfactory.LinuxFactory;
import com.iycc.pattern.factory.factorymethod.LinuxButtonFactory;
import com.iycc.pattern.factory.simplefactory.SimpleFactory;
import org.junit.Test;

/**
 * Created by iycc on 2018/3/11.
 */
public class Client {
    @Test
    public void testSimple(){
        SimpleFactory simpleFactory = new SimpleFactory();
        Object object = simpleFactory.getButton("Linux");
        System.out.println(object);
    }

    @Test
    public void testFactoryMethod(){
        LinuxButtonFactory linuxButtonFactory = new LinuxButtonFactory();
        Object object = linuxButtonFactory.getButton();
        System.out.println(object);
    }

    @Test
    public void testAbstractFactory(){
        LinuxFactory linuxFactory = new LinuxFactory();
        Object object = linuxFactory.getButton();
        System.out.println(object);
        object = linuxFactory.getTextBox();
        System.out.println(object);
    }
}
