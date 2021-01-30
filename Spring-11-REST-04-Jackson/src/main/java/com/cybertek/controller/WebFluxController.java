package com.cybertek.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class WebFluxController  {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();


}
