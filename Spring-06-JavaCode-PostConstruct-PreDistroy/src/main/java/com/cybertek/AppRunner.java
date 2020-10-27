package com.cybertek;

import com.cybertek.config.AppConfig;
import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        ApplicationContext container= new AnnotationConfigApplicationContext(AppConfig.class);

        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();

        ((AnnotationConfigApplicationContext) container).close(); //down cast container to close
    }
}
