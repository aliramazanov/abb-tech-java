package com.abb.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "CustomFilter", urlPatterns = { "/*" })
public class CustomFilter implements Filter {
    @Override
    public void doFilter (
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {
        System.out.println("Custom Filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
