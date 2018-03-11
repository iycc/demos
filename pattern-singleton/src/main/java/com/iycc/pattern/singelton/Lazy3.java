package com.iycc.pattern.singelton;

/**
 * 懒汉式单例 - 双重锁检查
 * volatile关键字 保证可见性 禁止指令重排序
 * Created by iycc on 2018/3/11.
 */
public class Lazy3 {
    public static volatile Lazy3 lazy3 = null;
    private Lazy3(){}
    public static Lazy3 getInstance(){
        if(lazy3 == null){
            synchronized (Lazy3.class) {
                if(lazy3  == null) {
                    lazy3 = new Lazy3();//并不是原子操作
                    //指令重排序可能会导致出现lazy3已被赋值（此时lazy3不为null）Lazy3()
                    //构造方法还未执行（Lazy3中的字段还都是默认值），此时若再有另一个
                    //线程来调用getInstance()方法会直接返回Lazy3（因为此时Lazy3已不为null）
                    //导致这个线程得到的lazy3实例是未初始化完全的，很可能会导致程序的异常。
                    //如果在单线程下则不会有问题，因为不管是先赋值lazy3还是先执行Lazy3()，
                    //最终在返回lazy3时Lazy3构造函数都初始化完了，多线程下则不能保证。
                }
            }
        }
        return lazy3;
    }
}
