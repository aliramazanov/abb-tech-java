package com.abb;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "OtherServlet", urlPatterns = { "/others" })
public class OtherServlet extends HttpServlet {
    
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        ServletContext ctx = getServletContext();
        
        Car car = (Car) ctx.getAttribute("car");
        
        res.getWriter().println(car);
    }
}
