package com.codeModule.entity;

/**
 * Created by sosoo on 2016/11/28.
 */
public class OperandInfo {
    public VarType getVarType() {
        return varType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getValue() {
        return value;
    }

    private VarType varType;
    private DataType dataType;
    private String value;

    public OperandInfo(String varType, String dataType, String value) {
        this.dataType = DataType.StringMap.get(dataType);
        this.varType = VarType.StringMap.get(varType);
        this.value = value;
    }
}
