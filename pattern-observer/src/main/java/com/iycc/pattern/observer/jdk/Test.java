package com.iycc.pattern.observer.jdk;

/**
 * Created by iycc on 2018/3/20.
 */
public class Test {
    public static void main(String[] args) {
        SpecialReporter reporter = new SpecialReporter();
        GlobalTimes n1 = new GlobalTimes(reporter);
        PeopleDaily n2 = new PeopleDaily(reporter);
        XinhuaDaily n3 = new XinhuaDaily(reporter);

        reporter.getNewNews("new news!");
        n2.remove();
        System.out.println("------------ PeopleDaily removed ----------------");
        reporter.getNewNews("another new news!");
    }
}
