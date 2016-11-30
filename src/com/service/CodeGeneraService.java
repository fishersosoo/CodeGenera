package com.service;

import com.codeModule.entity.INPUT;
import com.codeModule.entity.Program;
import com.codeModule.entity.variableModule;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by sosoo on 2016/11/28.
 */
public class CodeGeneraService {
    private ApplicationContext context;

    public static CodeGeneraService getInstance() {
        return instance;
    }

    private static CodeGeneraService instance;
    private static String HtmlTemplatePath;

    private CodeGeneraService(String contextPath) {
        context = new ClassPathXmlApplicationContext(contextPath);
    }

    public static void init(String contextPath) {
        if (instance == null) {
            instance = new CodeGeneraService(contextPath);
        }
    }

    public static void setHtmlTemplatePath(String htmlTemplatePath) {
        HtmlTemplatePath = htmlTemplatePath;
    }


    private Document ReadHtmlTemplate() throws IOException {
        try {
            File html_file = new File(HtmlTemplatePath);
            return Jsoup.parse(html_file, "UTF-8");
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public String generatorHTML(String jsonString) {
        try {
            Document html = ReadHtmlTemplate();
            Program program=parseJSON(jsonString);
            html.title(program.getName());
            ArrayList<variableModule> variableModules= (ArrayList<variableModule>) program.getVariableModules();
            for (variableModule module:
                 variableModules) {
                html=module.modifyHtml(html);
            }
            return html.html();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    private Program parseJSON(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> jsonMap = mapper.readValue(jsonString, Map.class);
            ArrayList<Object> variableModules= (ArrayList<Object>) jsonMap.get("variableArea");
            ArrayList<Object> procedureModules= (ArrayList<Object>) jsonMap.get("procedureArea");
            String name= (String) jsonMap.get("name");
            Program program=new Program(name);
            program.setContext(context);
            program.setVariableModules(variableModules);
            program.setProcedureModules(procedureModules);
            return program;
        }
        catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
