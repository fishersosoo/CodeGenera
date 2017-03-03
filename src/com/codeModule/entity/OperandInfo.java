package com.codeModule.entity;

/**
 * Created by sosoo on 2016/11/28.
 */
public class OperandInfo {
    VarType getVarType() {
        return varType;
    }

    public DataType getDataType() {
        return dataType;
    }

    String getValue() {
        return value;
    }

    private VarType varType;
    private DataType dataType;
    private String value;

    OperandInfo(String varType, String dataType, String value) {
        if (dataType!=null)
            this.dataType = DataType.StringMap.get(dataType);
        if (varType!=null)
            this.varType = VarType.StringMap.get(varType);
        this.value = value;
    }
}
