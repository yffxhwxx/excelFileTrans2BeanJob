import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext context=new FileSystemXmlApplicationContext("classpath:/spring/application.xml");
        context.start();
        while(true){

        }
    }
}
