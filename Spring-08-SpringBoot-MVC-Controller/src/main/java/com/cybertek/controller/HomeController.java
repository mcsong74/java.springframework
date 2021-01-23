package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/") //default "/"
    public String getRequestMapping1() {
        //method name is not very important. looking for RequestMapping parameter
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ozzy") //most of time using GET or POST
    public String getRequestMapping2() {
        return "ozzy";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cybertek") //default "/"
    public String getRequestMapping3() {
        return "cybertek";
    }

    @GetMapping("/spring")
    public String getMappingEx() {
        return "home";
    }

    @PostMapping("/spring")
    public String postMappingEx() {
        return "home";
    }

    @GetMapping("/home/{name}")
    public String pathVariableEx(@PathVariable("name") String name) {
        System.out.println("name = " + name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariableEx(@PathVariable("name") String name, @PathVariable("email") String email) {
        System.out.println("name = " + name);
        System.out.println("email = " + email);
        return "home";
    }

    @GetMapping("/home/course")
    public String requestParamEx(@RequestParam("course") String course) {
        System.out.println("course = " + course);
        return "ozzy";
    }

    @GetMapping(value = "/course2")
    public String requestParamEx2(@RequestParam(value = "course2", required = false, defaultValue = "Cybertek") String course2) {
        System.out.println("course2 = " + course2);
        return "ozzy";
    }

}
