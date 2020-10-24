package com.cybertek.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.cybertek") //will scan all packages under com.cybertek
public class AppConfig {

}
