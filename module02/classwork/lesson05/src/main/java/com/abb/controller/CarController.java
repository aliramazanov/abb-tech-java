package com.abb;

import com.abb.dto.CarDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CarServlet", urlPatterns = { "/cars" })
public class CarServlet extends HttpServlet {
    
    private static final ObjectMapper om = new ObjectMapper();
    
    @SuppressWarnings("CommentedOutCode")
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        CarDTO car = new CarDTO("Porsche", "green", 1996, 320,55536354,"DBCODE-00001" );
        CarDTO carTwo = new CarDTO("Mercedes-Benz", "black", 2025, 280, 55536354, "DBCODE-00002");
        
        ServletContext ctx = getServletContext();
        
        ctx.setAttribute("car", car);
        ctx.setAttribute("carTwo", carTwo);
        
        //        res.setStatus(200);
        //        res.setContentType("text/html");
        //
        //        PrintWriter pw = res.getWriter();
        //
        //         pw.println(
        //                "<h1> Car Response </h1>" +
        //                "<h4>" + car + "</h4>" +
        //                "<h4>" + carTwo + "</h4>" +
        //                "<div>" + ctx + "</div>"
        //        );
        
        
        res.setStatus(200);
        res.setContentType("application/json");
        res.getWriter().println(om.writeValueAsString(car));
    }
    
    @Override
    public void init () {
        log("Servlet Initialized: Car");
    }
}