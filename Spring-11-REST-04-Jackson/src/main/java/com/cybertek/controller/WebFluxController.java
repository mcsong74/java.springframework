package com.cybertek.controller;

import com.cybertek.entity.Genre;
import com.cybertek.entity.MovieCinema;
import com.cybertek.repository.GenreRepository;
import com.cybertek.repository.MovieCinemaRepository;
import com.cybertek.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class WebFluxController  {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    private MovieRepository movieRepository;
    private MovieCinemaRepository movieCinemaRepository;
    private GenreRepository genreRepository;

    public WebFluxController(MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllCinemaFlux(){
        return Flux.fromIterable(movieCinemaRepository.findAll()); //convert List to Flux structure
    }

    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> readMovieCinemaById(@PathVariable("id") Long id){
        //retrieving only one then, Mono
        return Mono.just(movieCinemaRepository.findById(id).get());
    }
}
