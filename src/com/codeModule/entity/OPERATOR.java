package com.codeModule.entity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
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
        if (jsonMap.containsKey("first")) {
            OperandInfo first = new OperandInfo((String) jsonMap.get("firstType"), null, (String) jsonMap.get("first"));
            Operands.add(first);
        }
        if (jsonMap.containsKey("second")) {
            OperandInfo second = new OperandInfo((String) jsonMap.get("secondType"), null, (String) jsonMap.get("second"));
            Operands.add(second);
        }
    }

    @Override
    public String generateJavascript() {
        try {
            String javascriptCode = "";
            if (assgin != null) {
                javascriptCode += assgin + " = ";
            }
            File operationXml = new File(System.getProperty("user.dir") + File.separator + "out" + File.separator
                    + "production" + File.separator + "CodeGenera" + File.separator + "config" + File.separator + "Operation.xml");
            Document operationsNode = Jsoup.parse(operationXml, "UTF-8");
            Element operationNode = operationsNode.getElementById(getOp());
            assert (operationNode != null);
            for (Element node :
                    operationNode.children()) {
                if (node.tagName().equals("operand")) {
                    int index = Integer.parseInt(node.html());
                    switch (Operands.get(index).getVarType()) {
                        case immediate:
                            javascriptCode += Operands.get(index).getValue() + " ";
                            break;
                        case VAR:
                            javascriptCode += Operands.get(index).getValue() + " ";
                            break;
                    }
                } else if (node.tagName().equals("symbol")) {
                    javascriptCode += node.html() + " ";
                }
            }
            javascriptCode += ";\n";
            return javascriptCode;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
