package com.cybertek.boostrap;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    private UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public DataGenerator(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        //Delete all
        userRepository.deleteAll();
        //create users
        User employee= new User("Ozzy", passwordEncoder.encode("ozzy123"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin123"),"ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User manager= new User("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");

        List<User> users = Arrays.asList(employee, admin, manager);

        userRepository.saveAll(users);

    }


}
