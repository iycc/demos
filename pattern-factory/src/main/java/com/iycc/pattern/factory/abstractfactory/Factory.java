package com.iycc.pattern.factory.abstractfactory;

import com.iycc.pattern.factory.beans.Button;
import com.iycc.pattern.factory.beans.TextBox;

/**
 * Created by iycc on 2018/3/11.
 */
public interface Factory {
    Button getButton();
    TextBox getTextBox();
}
