package com.codeModule.entity;

import java.util.ArrayList;

/**
 * Created by sosoo on 2016/11/28.
 */
public class WHILE extends procedureModule {
    private String moduleType="WHILE";
    private OPERATOR condition;
    private ArrayList<procedureModule> procedure= new ArrayList<>();
    public WHILE(String ID) {
        super(ID);
    }
}
