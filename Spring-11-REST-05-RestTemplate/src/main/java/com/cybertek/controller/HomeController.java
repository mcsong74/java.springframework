package com.cybertek.controller;

import com.cybertek.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HomeController {
    final String URI="https://jsonplaceholder.typicode.com/users";

    private RestTemplate restTemplate;

    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("")
    public User[] readAllUser(){
        //.getForEntity accepting arrays , so User[] is used, and after conversion returns ResponseEntity
        ResponseEntity<User[]> responseEntity=restTemplate.getForEntity(URI, User[].class);

        return responseEntity.getBody();
    }
}
