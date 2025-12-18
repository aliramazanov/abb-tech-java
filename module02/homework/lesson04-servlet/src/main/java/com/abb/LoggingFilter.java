package com.abb;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "LoggingFilter", urlPatterns = "/tasks")
public class LoggingFilter implements Filter {
    
    @Override
    public void doFilter (
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Logging Filter: " + httpRequest.getMethod() + " " + httpRequest.getRequestURI());
        
        chain.doFilter(request, response);
    }
}