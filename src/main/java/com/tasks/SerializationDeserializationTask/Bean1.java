package com.tasks.SerializationDeserializationTask;

import java.util.List;

public class Bean1 {

    private Bean2 propertyBean2;
    private int propertyInt;
    private Integer propertyInteger;
    private List propertyList;
    public Bean1(Bean2 propertyBean2) {
    }

    public Bean2 getPropertyBean2() {
        return propertyBean2;
    }

    public void setPropertyBean2(Bean2 propertyBean2) {
        this.propertyBean2 = propertyBean2;
    }

    public int getPropertyInt() {
        return propertyInt;
    }

    public void setPropertyInt(int propertyInt) {
        this.propertyInt = propertyInt;
    }

    public Integer getPropertyInteger() {
        return propertyInteger;
    }

    public void setPropertyInteger(Integer propertyInteger) {
        this.propertyInteger = propertyInteger;
    }

    public List getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List propertyList) {
        this.propertyList = propertyList;
    }
}
