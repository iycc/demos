package com.iycc.pattern.factory.abstractfactory;

import com.iycc.pattern.factory.beans.Button;
import com.iycc.pattern.factory.beans.LinuxButton;
import com.iycc.pattern.factory.beans.LinuxTextBox;
import com.iycc.pattern.factory.beans.TextBox;

/**
 * Created by iycc on 2018/3/11.
 */
public class LinuxFactory implements Factory {
    @Override
    public Button getButton() {
        return new LinuxButton();
    }

    @Override
    public TextBox getTextBox() {
        return new LinuxTextBox();
    }
}
