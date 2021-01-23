package com.cybertek;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication //to enable @ComponentScan, @Configuration, @EnableAutoConfiguration

public class Spring07SpringBootDemoApplication {

    public static void main(String[] args) {
//		SpringApplication.run(Spring07SpringBootDemoApplication.class, args); //creates container and all beans
        ApplicationContext container = SpringApplication.run(Spring07SpringBootDemoApplication.class, args);
        Course course = container.getBean("java", Course.class);
        System.out.println(course.getTeachingHours());
        ExtraSession course1 = container.getBean("officeHours", ExtraSession.class);
        System.out.println(course1.getHour());
        Course course3 = container.getBean("selenium", Course.class);
        course3.getTeachingHours();


    }

}
