package com.cybertek.controller;

import com.cybertek.entity.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {
    final String URI="https://jsonplaceholder.typicode.com/users";

    private RestTemplate restTemplate;

    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //using .getForEntity(,)
    @GetMapping
    public User[] readAllUser(){
        //.getForEntity returns arrays , so User[] is used,
        ResponseEntity<User[]> responseEntity=restTemplate.getForEntity(URI, User[].class);

        return responseEntity.getBody();
    }

    // using .getForObject(,,)
    @GetMapping(value="/{id}")
    public Object readUser(@PathVariable("id") Long id){
        String URL=URI+"/{id}"; // data from 3rd party api using ID
        return restTemplate.getForObject(URL, Object.class, id);
    }

    //https://dummyapi.io/data/api/user?limit=10 , example,  header is missing
    @GetMapping("/test")
    public ResponseEntity<Object> consumePostsFromDummyApi(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id", "lTE5abbDxdjGplutvTuc");

        // mapping headers to http entity structure
        HttpEntity<String> entity=new HttpEntity<>(headers);
        String url="https://dummyapi.io/data/api/user?limit=10";
        ResponseEntity<Object> response=restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        return response;
    }



}
