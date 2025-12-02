package com.abb;


import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CarServlet", urlPatterns = { "/cars" })
public class CarServlet extends HttpServlet {
    
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        Car car = new Car("Porsche", "green", 1996, 320);
        Car carTwo = new Car("Mercedes-Benz", "black", 2025, 280);
        
        ServletContext ctx = getServletContext();
        
        ctx.setAttribute("car", car);
        ctx.setAttribute("carTwo", carTwo);
        
        res.setStatus(200);
        res.setContentType("text/html");
        
        PrintWriter pw = res.getWriter();
        
        pw.println(
                "<h1> Car Response </h1>" +
                "<h4>" + car + "</h4>" +
                "<h4>" + carTwo + "</h4>" +
                "<div>" + ctx + "</div>"
        );
    }
    
    @Override
    public void init () {
        log("Servlet Initialized: Car");
    }
}
