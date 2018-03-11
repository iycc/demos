package com.iycc.pattern.singelton;
import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by iycc on 2018/3/11.
 */
public class TestSingleton {

    @Test
    public void test() {
        int count = 100;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        for(int i = 0; i < 100; i++){
            new Thread(()->{
                try {
                    cyclicBarrier.await(); // await数量达到 count 后，所有子线程同时启动
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Object instance = SingletonFactory.getInstance1(Object.class.getName());
                System.out.println(instance);
            }).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
