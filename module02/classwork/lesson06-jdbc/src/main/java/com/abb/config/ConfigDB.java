package com.abb.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConfigDB {
    
    private static final DataSource dataSource;
    
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("");
        config.setUsername("");
        config.setPassword("");
        config.setSchema("");
        config.setAutoCommit(true);
        config.setMinimumIdle(2);
        config.setIdleTimeout(10000);
        dataSource = new HikariDataSource(config);
    }
    
    public static Connection getConnection () {
        try {
            return dataSource.getConnection();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
