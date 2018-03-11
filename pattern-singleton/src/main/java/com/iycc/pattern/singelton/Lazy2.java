package com.iycc.pattern.singelton;

/**
 * 懒汉式单例 - 方法同步
 * 线程安全，效率低，不推荐
 * Created by iycc on 2018/3/11.
 */
public class Lazy2 {
    public static Lazy2 lazy2 = null;
    private Lazy2(){}
    public static synchronized Lazy2 getInstance(){
        if(lazy2 == null){
            lazy2 = new Lazy2();
        }
        return lazy2;
    }
}
