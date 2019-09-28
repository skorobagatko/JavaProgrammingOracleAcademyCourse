package com.skorobahatko.lecture8_jdbc.dao.impl;

import com.skorobahatko.lecture8_jdbc.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDao extends CrudDao<Movie> {

    public MovieDao() {
        super(Movie.class);
    }

    @Override
    protected List<Movie> readAll(ResultSet rs) throws SQLException {
        if (rs == null) return null;
        List<Movie> result = new ArrayList<>();
        while (rs.next()) {
            Movie movie = new Movie();
            movie.setId(rs.getInt("id"));
            movie.setTitle(rs.getString("title"));
            movie.setDuration(rs.getLong("duration"));
            movie.setDescription(rs.getString("description"));

            result.add(movie);
        }
        return result;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Movie entity) throws SQLException {
        // TODO
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Movie entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO movie(title, duration, description) VALUES (?, ?, ?);");
        preparedStatement.setString(1, entity.getTitle());
        preparedStatement.setLong(2, entity.getDuration());
        preparedStatement.setString(3, entity.getDescription());
        return preparedStatement;
    }
}
