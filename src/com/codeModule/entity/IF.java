package com.codeModule.entity;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by sosoo on 2016/11/28.
 */

public class IF extends procedureModule {
    private String moduleType = "IF";
    private OPERATOR false_condition;
    private OPERATOR true_condition;
    private ArrayList<procedureModule> true_procedure = new ArrayList<>();
    private ArrayList<procedureModule> false_procedure = new ArrayList<>();


    public IF() {
    }

    @Override
    public void init(Map<String, Object> jsonMap) {
        super.init(jsonMap);
        this.true_condition = new OPERATOR();
        true_condition.init((Map<String, Object>) jsonMap.get("true_condition"));
        ArrayList<Object> true_procedure_list = (ArrayList<Object>) jsonMap.get("true_procedure");
        for (Object true_procedure_map :
                true_procedure_list) {
            procedureModule oneProcedure = new procedureModule();
            oneProcedure.init((Map<String, Object>) true_procedure_map);
            true_procedure.add(oneProcedure);
        }
        if (jsonMap.containsKey("false_condition")) {
            this.false_condition = new OPERATOR();
            false_condition.init((Map<String, Object>) jsonMap.get("false_condition"));
        }
        if (jsonMap.containsKey("false_procedure")) {
            ArrayList<Object> false_procedure_list = (ArrayList<Object>) jsonMap.get("false_procedure");
            for (Object false_procedure_map :
                    false_procedure_list) {
                procedureModule oneProcedure = new procedureModule();
                oneProcedure.init((Map<String, Object>) false_procedure_map);
                false_procedure.add(oneProcedure);
            }
        }
    }

    @Override
    public String getJavaScriptCode() {
        String javaScriptCode = "";
        return javaScriptCode;
    }
}
