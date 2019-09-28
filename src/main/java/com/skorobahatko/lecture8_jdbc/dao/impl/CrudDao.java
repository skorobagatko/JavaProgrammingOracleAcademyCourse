package com.skorobahatko.lecture8_jdbc.dao.impl;

import com.skorobahatko.lecture8_jdbc.dao.api.Dao;
import com.skorobahatko.lecture8_jdbc.datasource.DataSource;
import com.skorobahatko.lecture8_jdbc.model.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class CrudDao<T extends Entity<Integer>> implements Dao<Integer, T> {

    public static final String SELECT_ALL_SQL = "SELECT * FROM %s;";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM %s WHERE id=?;";

    private Class<T> type;
    private DataSource dataSource;

    public CrudDao(Class<T> type) {
        this.type = type;
        dataSource = DataSource.getInstance();
    }

    @Override
    public List<T> getAll() {
        String sql = String.format(SELECT_ALL_SQL, type.getSimpleName().toLowerCase());

        List<T> result = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            result = readAll(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public T getById(Integer id) {
        String sql = String.format(SELECT_BY_ID_SQL, type.getSimpleName().toLowerCase());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // TODO

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    protected abstract List<T> readAll(ResultSet rs) throws SQLException;

    protected abstract PreparedStatement createUpdateStatement(Connection connection, T entity) throws SQLException;

    protected abstract PreparedStatement createInsertStatement(Connection connection, T entity) throws SQLException;
}
