package com.skorobahatko.lecture8_jdbc.web;

import com.skorobahatko.lecture8_jdbc.dto.MovieDTO;
import com.skorobahatko.lecture8_jdbc.service.api.Service;
import com.skorobahatko.lecture8_jdbc.service.impl.MovieServiceImpl;

public class App {

    public static void main(String[] args) {
        Service<Integer, MovieDTO> movieService = MovieServiceImpl.getInstance();
        movieService.save(new MovieDTO("Terminator 2", "Action", 120));
        movieService.getAll().forEach(System.out::println);
    }

}
