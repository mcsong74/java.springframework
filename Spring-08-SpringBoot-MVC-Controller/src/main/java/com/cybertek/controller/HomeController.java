package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping("/") //default "/"
    public String getRequestMapping1(){
        //method name is not very important. looking for RequestMapping parameter
        return "home";
    }
    @RequestMapping(method = RequestMethod.GET, value="/ozzy") //most of time using GET or POST
    public String getRequestMapping2(){
        return "ozzy";
    }
    @RequestMapping(method=RequestMethod.GET, value="/cybertek") //default "/"
    public String getRequestMapping3(){
        return "cybertek";
    }

    @GetMapping("/spring")
    public String getMappingEx(){
        return "home";
    }
    @PostMapping("/spring")
    public String postMappingEx(){
        return "home";
    }



}
