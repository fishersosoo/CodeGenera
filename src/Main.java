import com.codeModule.entity.DataType;
import com.service.CodeGeneraService;
import net.sf.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //        ApplicationContext context =
        //                new ClassPathXmlApplicationContext("Beans.xml");
        CodeGeneraService.init("config\\Beans.xml");
        CodeGeneraService.setHtmlTemplatePath(System.getProperty("user.dir")+ File.separator +"out"+File.separator
                +"production"+File.separator +"CodeGenera"+File.separator +"com" + File.separator + "codeModule" + File.separator +
                "FileTemplate" + File.separator + "HtmlTemplate.html");
        CodeGeneraService codeGeneraService=CodeGeneraService.getInstance();
        System.out.println(codeGeneraService.generatorHTML(""));
    }
}
