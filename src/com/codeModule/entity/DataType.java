package com.codeModule.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sosoo on 2016/11/27.
 */
public enum DataType {
    NumberType("number"),
    BoolType("bool"),
    ArrayType("list");
    public String name;
    public static Map<String, DataType> StringMap = new HashMap<>();

    static {
        StringMap.put("number", DataType.NumberType);
        StringMap.put("bool", DataType.BoolType);
        StringMap.put("list", DataType.ArrayType);
    }

    ;

    private DataType(String name) {
        this.name = name;
    }
}
