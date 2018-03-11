package com.iycc.pattern.factory.simplefactory;

import com.iycc.pattern.factory.beans.Button;
import com.iycc.pattern.factory.beans.LinuxButton;
import com.iycc.pattern.factory.beans.WindowsButton;

/**
 * 简单工厂
 * Created by iycc on 2018/3/11.
 */
public class SimpleFactory {
    public Button getButton(String type){
        switch(type)
        {
            case "Linux":
                return new LinuxButton();
            case "Windows":
                return new WindowsButton();
            default:
                System.out.println("not supported!");
                return null;
        }
    }

}
