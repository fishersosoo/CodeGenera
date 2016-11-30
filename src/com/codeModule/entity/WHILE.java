package com.codeModule.entity;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by sosoo on 2016/11/28.
 */
public class WHILE extends procedureModule {
    private String moduleType = "WHILE";
    private OPERATOR condition;
    private ArrayList<procedureModule> procedure = new ArrayList<>();

    public WHILE() {
    }

    @Override
    public void init(Map<String, Object> jsonMap) {
        super.init(jsonMap);
    }
}
