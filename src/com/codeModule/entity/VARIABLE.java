package com.codeModule.entity;

import org.jsoup.nodes.Document;

import java.util.Map;

/**
 * Created by sosoo on 2016/11/28.
 */
public class VARIABLE extends variableModule {
    private String moduleType = "VARIABLE";
    private VarType varType;
    private String value;

    public VarType getVarType() {
        return varType;
    }

    public String getValue() {
        return value;
    }


    public VARIABLE() {
    }

    @Override
    public void init(Map<String, Object> jsonMap) {
        this.value = (String) jsonMap.get("value");
        this.varType = VarType.StringMap.get(jsonMap.get("initType"));
    }

    @Override
    public Document modifyHtml(Document html) {
        return html;
    }
}
