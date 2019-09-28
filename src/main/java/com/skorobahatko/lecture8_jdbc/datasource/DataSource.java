package com.skorobahatko.lecture8_jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.skorobahatko.lecture8_jdbc.helper.PropertyHolder;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public final class DataSource {

    private static ComboPooledDataSource connectionPool;
    private static DataSource instance;

    private DataSource() {
        initConnectionPool();
    }

    public static synchronized DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
          connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static void initConnectionPool() {
        connectionPool = new ComboPooledDataSource();
        PropertyHolder propertyHolder = PropertyHolder.getInstance();
        try {
            connectionPool.setDriverClass(propertyHolder.getDbDriver());
            connectionPool.setJdbcUrl(propertyHolder.getJdbcUrl());
            connectionPool.setUser(propertyHolder.getDbUserLogin());
            connectionPool.setPassword(propertyHolder.getDbUserPassword());

            connectionPool.setMinPoolSize(5);
            connectionPool.setAcquireIncrement(1);
            connectionPool.setMaxPoolSize(100);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

}
