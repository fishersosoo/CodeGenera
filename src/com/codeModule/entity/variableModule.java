package com.codeModule.entity;

/**
 * Created by sosoo on 2016/11/28.
 */
public class variableModule extends baseModule {
    private String name;

    public String getName() {
        return name;
    }

    public DataType getDtype() {
        return dtype;
    }

    private DataType dtype;

    public variableModule(String ID, String name, String dataTypeStr) {
        super(ID);
        this.name = name;
        this.dtype = DataType.StringMap.get(dataTypeStr);
    }
}
