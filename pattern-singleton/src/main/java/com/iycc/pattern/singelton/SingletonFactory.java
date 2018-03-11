package com.iycc.pattern.singelton;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式单例
 * Created by iycc on 2018/3/11.
 */
public class SingletonFactory {
    private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    /**
     * hashmap的判断和放入不是原子操作，存在线程安全问题，多线程并发时，不能保证单例
     * @param className
     * @return
     */
    public static Object getInstance(String className) {
        if (!concurrentHashMap.containsKey(className)) {
            Object obj = null;
            try {
                obj = Class.forName(className).newInstance();
                concurrentHashMap.put(className, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;
        } else {
            return concurrentHashMap.get(className);
        }
    }

    /**
     * 此方法可保证线程安全
     * @param className
     * @return
     */
    public static Object getInstance1(String className) {
        Object obj = null;
        try {
            obj = Class.forName(className).newInstance();
            Object returnObj = concurrentHashMap.putIfAbsent(className, obj);// 不存在则放入，已存在则返回
            if (returnObj != null) {
                obj = returnObj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
