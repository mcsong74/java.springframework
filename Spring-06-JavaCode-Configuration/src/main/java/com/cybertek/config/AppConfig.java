package com.cybertek.config;

import com.cybertek.services.Java;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.cybertek") //will scan all packages under com.cybertek
public class AppConfig {

    @Bean
    public Java java(){
        return new Java();
    }
    @Bean
    public Selenium selenium(){
        return new Selenium();
    }

}
