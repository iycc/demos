package com.iycc.pattern.factory.factorymethod;

import com.iycc.pattern.factory.beans.Button;
import com.iycc.pattern.factory.beans.WindowsButton;

/**
 * Created by iycc on 2018/3/11.
 */
public class WindowsButtonFactory implements ButtonFactory {
    @Override
    public Button getButton() {
        return new WindowsButton();
    }
}
