package com.cybertek.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration //3rd party bean, need @Configuration
@EnableWebSecurity // enables spring security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserPrincipalDetailsServiceImpl userPrincipalDetailsService;

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//        auth.inMemoryAuthentication()
//                //create user credential and assign role
//                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
//                .and()
//                .withUser("ozzy").password(passwordEncoder().encode("ozzy123")).roles("USER")
//                .and()
//                .withUser("manager").password(passwordEncoder().encode("manager123")).roles("MANAGER");
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .authorizeRequests() //request should be authorized
//                .antMatchers("index.html").permitAll()
                .antMatchers("/profile/**").authenticated() //any user will have access to profile folder
//                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/management/**").hasAnyAuthority("ADMIN", "MANAGER")
//                .anyRequest().authenticated()  //incoming request be authenticated
                .and()
                .formLogin()
                .loginPage("/login") //login
                .defaultSuccessUrl("/index")    //after open login page, if success, navigate to the url in parameter
                .failureUrl("/login?error=true")
                .permitAll()   //login page has access to everyone
                .and()
                .logout() //for logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //always fix, methods and param same.
                .logoutSuccessUrl("/login?logout=true")
                .and()
                .rememberMe() //remember me
                .tokenValiditySeconds(120)
                .key("cybertekSecrete")
                .userDetailsService(userPrincipalDetailsService);


    }


    @Bean
    PasswordEncoder passwordEncoder() {
        //PasswordEncoder = interface, passwordEncoder - polymorphism
        return new BCryptPasswordEncoder();
    }


}
