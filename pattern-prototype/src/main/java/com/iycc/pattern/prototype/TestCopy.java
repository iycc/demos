package com.iycc.pattern.prototype;

import com.iycc.pattern.prototype.beans.DestinationObject;
import com.iycc.pattern.prototype.beans.SourceObject;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Created by iycc on 2018/3/11.
 */
public class TestCopy {
    public static void main(String[] args) throws IllegalAccessException,
            InvocationTargetException {

        final Mapper mapper = new DozerBeanMapper();
        final int times = 1000000;

        new Thread(() -> {
            long start = System.currentTimeMillis();
            DestinationObject destObject = null;
            for (int j = 0; j < times; j++) {
                destObject = mapper.map(getSourceObe(),
                        DestinationObject.class);
            }
            System.out.println("Mapper cost "
                    + (System.currentTimeMillis() - start));
            System.out.println(destObject);
        }).start();

        new Thread(() -> {
            DestinationObject destObject2 = new DestinationObject();
            long start2 = System.currentTimeMillis();
            for (int j = 0; j < times; j++) {
                try {
                    org.apache.commons.beanutils.BeanUtils.copyProperties(
                            destObject2, getSourceObe());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Apache Common BeanUtils cost "
                    + (System.currentTimeMillis() - start2));
            System.out.println(destObject2);
        }).start();

        new Thread(() -> {
            DestinationObject destObject2 = new DestinationObject();
            long start2 = System.currentTimeMillis();
            for (int j = 0; j < times; j++) {
                org.springframework.beans.BeanUtils.copyProperties(
                        getSourceObe(), destObject2);
            }
            System.out.println("Spring BeanUtils cost "
                    + (System.currentTimeMillis() - start2));
            System.out.println(destObject2);
        }).start();

    }

    private static SourceObject getSourceObe() {
        SourceObject sourceObject = new SourceObject();
        sourceObject.setI(10);
        sourceObject.setStr("this is a 中");
        sourceObject.setArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        sourceObject.setListStr(Arrays.asList("1", "2", "1", "2", "1", "2", "1", "2"));

        DestinationObject innerDestObject = new DestinationObject();
        innerDestObject.setI(100);
        innerDestObject.setStr("innerDestObject");
        sourceObject.setDest(innerDestObject);

        return sourceObject;
    }

}
