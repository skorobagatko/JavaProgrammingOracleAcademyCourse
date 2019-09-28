package com.skorobahatko.lecture8_jdbc.service.impl;

import com.skorobahatko.lecture8_jdbc.dao.DaoFactory;
import com.skorobahatko.lecture8_jdbc.dao.api.Dao;
import com.skorobahatko.lecture8_jdbc.dto.MovieDTO;
import com.skorobahatko.lecture8_jdbc.mapper.BeanMapper;
import com.skorobahatko.lecture8_jdbc.model.Movie;
import com.skorobahatko.lecture8_jdbc.service.api.Service;

import java.util.List;

public class MovieServiceImpl implements Service<Integer, MovieDTO> {

    private static MovieServiceImpl instance;

    private Dao<Integer, Movie> movieDao;
    private BeanMapper beanMapper;

    private MovieServiceImpl() {
        movieDao = DaoFactory.getInstance().getMovieDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized MovieServiceImpl getInstance() {
        if (instance == null) {
            instance = new MovieServiceImpl();
        }
        return instance;
    }

    @Override
    public List<MovieDTO> getAll() {
        List<Movie> movies = movieDao.getAll();
        List<MovieDTO> movieDTOs = beanMapper.listMapToList(movies, MovieDTO.class);
        return movieDTOs;
    }

    @Override
    public MovieDTO getById(Integer id) {
        Movie movie = movieDao.getById(id);
        MovieDTO movieDTO = beanMapper.singleMapper(movie, MovieDTO.class);
        return null;
    }

    @Override
    public void save(MovieDTO movieDto) {
        Movie movie = beanMapper.singleMapper(movieDto, Movie.class);
        movieDao.save(movie);
    }

    @Override
    public void delete(Integer key) {
        movieDao.delete(key);
    }

    @Override
    public void update(MovieDTO entity) {
        Movie movie = beanMapper.singleMapper(entity, Movie.class);
        movieDao.update(movie);
    }
}
