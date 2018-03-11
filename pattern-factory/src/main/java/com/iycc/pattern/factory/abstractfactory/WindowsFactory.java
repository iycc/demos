package com.iycc.pattern.factory.abstractfactory;

import com.iycc.pattern.factory.beans.*;

/**
 * Created by iycc on 2018/3/11.
 */
public class WindowsFactory implements Factory {
    @Override
    public Button getButton() {
        return new WindowsButton();
    }

    @Override
    public TextBox getTextBox() {
        return new WindowsTextBox();
    }
}
