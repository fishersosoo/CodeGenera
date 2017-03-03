package com.codeModule.entity;

import org.jsoup.nodes.Document;

import java.util.Map;

/**
 * Created by sosoo on 2016/11/28.
 */
public class variableModule extends baseModule {
    private String name;

    private DataType dtype;

    String getName() {
        return name;
    }

    public DataType getDtype() {
        return dtype;
    }

    public variableModule() {
    }

    @Override
    protected void init(Map<String, Object> jsonMap) {
        super.init(jsonMap);
        this.name = (String) jsonMap.get("name");
        this.dtype = DataType.StringMap.get(jsonMap.get("dtype"));
    }

    public Document modifyHtml(Document html) {
        return html;
    }
}
