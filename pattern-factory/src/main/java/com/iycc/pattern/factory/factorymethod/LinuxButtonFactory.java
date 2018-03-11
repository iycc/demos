package com.iycc.pattern.factory.factorymethod;

import com.iycc.pattern.factory.beans.Button;
import com.iycc.pattern.factory.beans.LinuxButton;

/**
 * Created by iycc on 2018/3/11.
 */
public class LinuxButtonFactory implements ButtonFactory {
    @Override
    public Button getButton() {
        return new LinuxButton();
    }
}
