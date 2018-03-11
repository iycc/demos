package com.iycc.pattern.singelton;

/**
 * 懒汉式单例(线程不安全)
 * Created by iycc on 2018/3/11.
 */
public class Lazy1 {
    public static Lazy1 lazy1 = null;
    private Lazy1(){}
    public static Lazy1 getInstance(){
        if(lazy1 == null){
            lazy1 = new Lazy1();
        }
        return lazy1;
    }
}
