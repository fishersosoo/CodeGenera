package com.codeModule.entity;

import java.util.ArrayList;

/**
 * Created by sosoo on 2016/11/28.
 */
public class OPERATOR extends procedureModule {
    private String op;
    private String moduleType="OPERATOR";
    private ArrayList<OperandInfo> Operands=new ArrayList<>();
    private String assgin;
    public OPERATOR(String ID, String op) {
        super(ID);
        this.op = op;
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
}
