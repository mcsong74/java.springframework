package com.cybertek;

import com.cybertek.config.AppConfig;
import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        ApplicationContext container=new AnnotationConfigApplicationContext(AppConfig.class); //create container using
        // Java Code
        Course course= container.getBean("java", Course.class);
        course.getTeachingHours();
        System.out.println(course.toString());
    }
}


