package com.iycc.pattern.observer.listener.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 事件的注册和监听
 * Created by iycc on 2018/3/21.
 */
public class EventListener {
    // Map相当于是一个注册器
    protected Map<Enum, Event> events = new HashMap<>();

    public void addListener(Enum eventType, Object target, Method callback) {
        // 注册事件
        // 用反射调用这个方法
        events.put(eventType, new Event(target, callback));
    }

    private void trigger(Event e) {
        e.setSource(this);
        e.setTime(System.currentTimeMillis());
        try {
            e.getCallback().invoke(e.getTarget(), e); // invoke方法时，把 e 作为参数
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    protected void trigger(Enum call) {
        if (!this.events.containsKey(call)) {
            return;
        }
        trigger(this.events.get(call).setTrigger(call.toString()));
    }

}
