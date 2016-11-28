package com.codeModule.entity;

/**
 * Created by sosoo on 2016/11/28.
 */
public class VARIABLE extends variableModule {
    private String moduleType="VARIABLE";
    public VarType getVarType() {
        return varType;
    }

    public String getValue() {
        return value;
    }

    private VarType varType;
    private String value;

    public VARIABLE(String ID, String name, String dataTypeStr, String initTypeStr, String value) {
        super(ID, name, dataTypeStr);
        this.varType = VarType.StringMap.get(initTypeStr);
        this.value = value;
    }
}
