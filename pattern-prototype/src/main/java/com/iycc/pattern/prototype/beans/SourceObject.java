package com.iycc.pattern.prototype.beans;

import java.util.List;

/**
 * Created by iycc on 2018/3/11.
 */
public class SourceObject {
    private int i;
    private String str;
    private DestinationObject dest;
    private  int[] array;
    private List<String> listStr;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public DestinationObject getDest() {
        return dest;
    }

    public void setDest(DestinationObject dest) {
        this.dest = dest;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public List<String> getListStr() {
        return listStr;
    }

    public void setListStr(List<String> listStr) {
        this.listStr = listStr;
    }
}
