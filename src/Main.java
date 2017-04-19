import com.service.CodeGeneraService;
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
    public static void main(String[] args)  {
        ApplicationContext
                context = new ClassPathXmlApplicationContext("config"+File.separator+"Beans.xml");
        CodeGeneraService codeGeneraService=(CodeGeneraService)context.getBean("codeGeneraService");
        try {
            System.out.println(codeGeneraService);
            System.out.println(codeGeneraService.generateCode(readToString(System.getProperty("user.dir")+ File.separator +"out"+File.separator
                    +"production"+File.separator +"CodeGenera"+File.separator +"test.json")));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

}