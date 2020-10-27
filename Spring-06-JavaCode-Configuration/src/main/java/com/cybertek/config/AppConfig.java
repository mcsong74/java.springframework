package com.cybertek.config;

import com.cybertek.interfaces.ExtraSessions;
import com.cybertek.services.Java;
import com.cybertek.services.OfficeHours;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

//@Component
@Configuration
@ComponentScan("com.cybertek") //will scan all packages under com.cybertek
@PropertySource("classpath:application.properties") // Value
public class AppConfig {

    @Bean
//    @Scope("prototype")
    public Java java(){ //3rd party class, can inject this way
//        return new Java(officeHours());
        return new Java(extraSessions());
    }
    @Bean
    public Selenium selenium(){
        return new Selenium();
    }//3rd party class, can inject this way
//    @Bean
//    public OfficeHours officeHours(){
//        return new OfficeHours();
//    }
    @Bean//3rd party class, can inject this way
    public ExtraSessions extraSessions(){ //ExtraSessions ex=new OfficeHours(); //more loosely couple
        return new OfficeHours();
    }

}
