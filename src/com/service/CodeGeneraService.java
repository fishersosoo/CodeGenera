package com.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;

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

    public String generatorHTML(String jsonString) {
        try {
            Document html = ReadHtmlTemplate();
            return html.html();
        } catch (Exception e) {
            System.out.println(e.toString());
            return "";
        }
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
}
