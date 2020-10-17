import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
//        BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext container=new ClassPathXmlApplicationContext("config.xml");

        Mentor mentor=(Mentor) container.getBean("fullTimeMentor");
        mentor.createAccount();

        mentor= (Mentor) container.getBean("partTimeMentor");
        mentor.createAccount();

        Mentor mentor1=container.getBean("fullTimeMentor", Mentor.class);  //2nd parameter(interface)-return object type
        mentor1.createAccount();

    }
}
