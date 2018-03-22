package com.iycc.pattern.observer.listener.mouse;

import com.iycc.pattern.observer.listener.core.Event;

import java.lang.reflect.Method;

/**
 * Created by iycc on 2018/3/21.
 */
public class MouseTest {

    public static void main(String[] args) {
        // 观察者和被观察者之间没有必然联系 注册的时候，才产生联系
        // 解耦
        try {
            MouseEventCallback callback = new MouseEventCallback();
            Method onClick = MouseEventCallback.class.getMethod("onClick", Event.class);
            Mouse mouse = new Mouse();
            mouse.addListener(MouseEventType.ON_CLICK, callback, onClick);
            mouse.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
