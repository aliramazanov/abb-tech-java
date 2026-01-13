package com.abb.springscopelesson;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class DatabaseConfig {
    private final String connectionUrl;
    
    public DatabaseConfig () {
        this.connectionUrl = "jdbc:postgresql://localhost:5432/mydb";
    }
}
