package com.codeModule.entity;

/**
 * Created by sosoo on 2016/11/28.
 */
public class INPUT extends variableModule {
    private String moduleType = "INPUT";
    private String desc;

    public INPUT(String ID, String name, String dataTypeStr, String desc) {
        super(ID, name, dataTypeStr);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
