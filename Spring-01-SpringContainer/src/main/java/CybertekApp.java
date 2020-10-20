import interfaces.Mentor;
import interfaces.Staff;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.ConversionService;
import org.springframework.util.StringValueResolver;

import java.beans.PropertyEditor;
import java.lang.annotation.Annotation;
import java.security.AccessControlContext;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CybertekApp {
    public static void main(String[] args) {
//        BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext container=new ClassPathXmlApplicationContext("config.xml", "config2.xml");

        Mentor mentor=(Mentor) container.getBean("fullTimeMentor");
        mentor.createAccount();

        mentor= (Mentor) container.getBean("partTimeMentor");
        mentor.createAccount();

        Mentor mentor1=container.getBean("fullTimeMentor", Mentor.class);  //2nd parameter(interface)-return object type
        mentor1.createAccount();

        Mentor mentor2=container.getBean("fullTimeMentor", Mentor.class);
        mentor2.createAccount();

        Staff staff=container.getBean("fullTimeStaff", Staff.class);
        staff.createAccount();
        staff=container.getBean("partTimeStaff", Staff.class);
        staff.createAccount();

        Arrays.stream(container.getBeanNamesForType(Staff.class)).forEach(b->System.out.println("name= "+b));
        Arrays.stream(container.getBeanNamesForType(Mentor.class)).forEach(b->System.out.println(b.toString()));


    }
}
