package com.abb;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "TimingFilter", urlPatterns = "/users")
public class TimingFilter implements Filter {
    
    @Override
    public void doFilter (
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long duration = System.currentTimeMillis() - start;
        
        System.out.println("Timing Filter: Request took " + duration + "ms");
    }
}