package com.abb.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.logging.Logger;

@WebListener
public class CustomListener implements ServletContextListener {
    private static final String CustomListener = "CustomListener";
    private static final Logger logger = Logger.getLogger(CustomListener);
    
    @Override
    public void contextDestroyed (ServletContextEvent sce) {
        logger.info("CTX Destroyed");
    }
    
    @Override
    public void contextInitialized (ServletContextEvent sce) {
        logger.info("CTX Initialized");
    }
}
