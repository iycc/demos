package com.iycc.pattern.observer.listener.subject;

import com.iycc.pattern.observer.listener.core.Event;

import java.lang.reflect.Method;

/**
 * Created by iycc on 2018/3/21.
 */
public class ObserverTest {

    public static void main(String[] args) {
        try {
            //观察者
            Observer observer = new Observer();
            Method advice = Observer.class.getMethod("advice", new Class<?>[]{Event.class});
            //被观察对象
            Subject subject = new Subject();
            subject.addListener(SubjectEventType.ON_ADD, observer, advice);
            subject.addListener(SubjectEventType.ON_EDIT, observer, advice);
            subject.addListener(SubjectEventType.ON_REMOVE, observer, advice);
            subject.addListener(SubjectEventType.ON_QUERY, observer, advice);

            subject.add();
            subject.remove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
