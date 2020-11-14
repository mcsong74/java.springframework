package com.cybertek.controller;

import com.cybertek.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String studentHomePage(Model model){
//        String name="Ozzy";
        model.addAttribute("name", "Ozzy");
        model.addAttribute("school", "Cybertek");
        model.addAttribute("course", "Java Developer - Spring boot MVC - Thymeleaf");
        String subject="Collections";
        model.addAttribute("subject", subject);
        //create some random studentid and show it in your UI
        Random rnd=new Random();
        int rndId=rnd.nextInt(1000);
        model.addAttribute("studentid", rndId);
        //List
        List<Integer> numbers=new ArrayList<>();
        for(int i=4; i<8; i++){
            numbers.add(i);
        }
        model.addAttribute("numbers", numbers);
        //print your birthday
        LocalDate birthday=LocalDate.now().minusYears(46);
        model.addAttribute("birthday", birthday);
        //Model
        Student student = new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);
        return "student/welcome";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "student/register";
    }
}
