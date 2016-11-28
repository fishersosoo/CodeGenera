package com.codeModule.entity;

import java.util.ArrayList;

/**
 * Created by sosoo on 2016/11/28.
 */
public class IF extends procedureModule {
    private String moduleType="IF";
    private OPERATOR false_condition;
    private OPERATOR true_condition;
    private ArrayList<procedureModule> true_procedure= new ArrayList<>();
    private ArrayList<procedureModule> flase_procedure= new ArrayList<>();
    public IF(String ID) {
        super(ID);
    }
}
