package com.skorobahatko.lecture8_jdbc.dao;

import com.skorobahatko.lecture8_jdbc.dao.impl.MovieDao;

public class DaoFactory {

    private static DaoFactory instance;

    private MovieDao movieDao;

    private DaoFactory() {
        movieDao = new MovieDao();
    }

    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public MovieDao getMovieDao() {
        return movieDao;
    }

}
