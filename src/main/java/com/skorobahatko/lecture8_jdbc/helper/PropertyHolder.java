package com.skorobahatko.lecture8_jdbc.helper;

import java.io.IOException;
import java.util.Properties;

public final class PropertyHolder {

    private static PropertyHolder instance;

    private boolean isInMemoryDb;
    private String jdbcUrl;
    private String dbUserLogin;
    private String dbUserPassword;
    private String dbDriver;

    private PropertyHolder() {
        loadProperties();
    }

    public static synchronized PropertyHolder getInstance() {
        if (instance == null) {
            instance = new PropertyHolder();
        }
        return instance;
    }

    private void loadProperties() {
        Properties prop = new Properties();
        try {
            prop.load(PropertyHolder.class.getClassLoader().getResourceAsStream("application.properties"));

            isInMemoryDb = Boolean.valueOf(prop.getProperty("isInMemoryDb"));
            jdbcUrl = prop.getProperty("jdbcUrl");
            dbUserLogin = prop.getProperty("dbUserLogin");
            dbUserPassword = prop.getProperty("dbUserPassword");
            dbDriver = prop.getProperty("dbDriver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isInMemoryDb() {
        return isInMemoryDb;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getDbUserLogin() {
        return dbUserLogin;
    }

    public String getDbUserPassword() {
        return dbUserPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }

}
