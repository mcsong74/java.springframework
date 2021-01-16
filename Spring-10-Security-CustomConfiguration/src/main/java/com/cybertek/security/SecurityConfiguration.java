package com.cybertek.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration //3rd party bean, need @Configuration
@EnableWebSecurity // enables spring security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .authorizeRequests() //request should be authorized
                .anyRequest().authenticated()  //incoming request be authenticated
                .and()
                .httpBasic();   //perform basic http authentication

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication()
                //create user credential and assign role
                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
                .and()
                .withUser("ozzy").password(passwordEncoder().encode("ozzy123")).roles("USER");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        //PasswordEncoder = interface, passwordEncoder - polymorphism
        return new BCryptPasswordEncoder();
    }




}
