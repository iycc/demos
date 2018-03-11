package com.iycc.pattern.singelton;
/**
 * 饿汉式单例
 * 优点：写法简单，无并发问题
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 * Created by iycc on 2018/3/11.
 */
public class Hungry {
    public static final Hungry hungry = new Hungry();

    private Hungry(){}

    public static Hungry getInstance(){
        return hungry;
    }
}
