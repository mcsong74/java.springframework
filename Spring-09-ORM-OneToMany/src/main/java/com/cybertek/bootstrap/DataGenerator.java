package com.cybertek.bootstrap;

import com.cybertek.entity.Address;
import com.cybertek.entity.Person;
import com.cybertek.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;
    @Override
    public void run(String... args) throws Exception {
        Person p1= new Person("Mike", "Smith");
        Person p2= new Person("Ozzy", "Kmith");
        Person p3= new Person("Tedd", "Bbith");

        Address a1= new Address("123 King St", "12345");
        Address a2= new Address("234 Elm St", "52543");
        Address a3= new Address("542 Java St", "22414");

        p1.setAddresses(Arrays.asList(a1,a2));
        personRepository.save(p1);
    }
}
