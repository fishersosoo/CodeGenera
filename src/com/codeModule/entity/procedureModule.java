package com.codeModule.entity;

import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by sosoo on 2016/11/28.
 */
public class procedureModule extends baseModule {
    protected ApplicationContext context;
    public procedureModule() {
    }

    @Override
    protected void init(Map<String, Object> jsonMap) {
        super.init(jsonMap);
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext Context) {
        this.context = Context;
    }
}
