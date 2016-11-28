package com.codeModule.entity;

/**
 * Created by sosoo on 2016/11/28.
 */
public class OUTPUT extends variableModule {
    private String desc;

    public OUTPUT(String ID, String name, String dataTypeStr, String desc) {
        super(ID, name, dataTypeStr);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
