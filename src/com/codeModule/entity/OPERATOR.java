package com.codeModule.entity;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by sosoo on 2016/11/28.
 */
public class OPERATOR extends procedureModule {
    private String op;
    private String moduleType = "OPERATOR";
    private ArrayList<OperandInfo> Operands = new ArrayList<>();
    private String assgin;

    public OPERATOR() {
    }

    public String getOp() {
        return op;
    }

    public String getModuleType() {
        return moduleType;
    }

    public String getAssgin() {
        return assgin;
    }

    public void setAssgin(String assgin) {
        this.assgin = assgin;
    }

    @Override
    public void init(Map<String, Object> jsonMap) {
        super.init(jsonMap);
        this.op = (String) jsonMap.get("op");
        if (jsonMap.containsKey("assign")) {
            this.assgin = (String) jsonMap.get("assign");
        }
    }

}
