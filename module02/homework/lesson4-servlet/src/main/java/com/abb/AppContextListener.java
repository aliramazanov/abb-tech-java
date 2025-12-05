package com.abb;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized (ServletContextEvent ctx) {
        System.out.println("*** Application Started ***");
        ctx.getServletContext().setAttribute("requestCounter", "0");
    }
    
    @Override
    public void contextDestroyed (ServletContextEvent ctx) {
        System.out.println("*** Application Stopped ***");
    }
}