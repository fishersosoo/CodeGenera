import com.codeModule.entity.DataType;
import com.service.CodeGeneraService;
import net.sf.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

public class Main {
    public static String readToString(String fileName) {
        String encoding = "utf-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) throws IOException {
        CodeGeneraService.init("config"+File.separator+"Beans.xml");
        CodeGeneraService.setHtmlTemplatePath(System.getProperty("user.dir")+ File.separator +"out"+File.separator
                +"production"+File.separator +"CodeGenera"+File.separator +"com" + File.separator + "codeModule" + File.separator +
                "FileTemplate" + File.separator + "HtmlTemplate.html");
        CodeGeneraService codeGeneraService=CodeGeneraService.getInstance();
        System.out.println(codeGeneraService.generatorHTML(readToString(System.getProperty("user.dir")+ File.separator +"out"+File.separator
                +"production"+File.separator +"CodeGenera"+File.separator +"test.json")));
    }
}
