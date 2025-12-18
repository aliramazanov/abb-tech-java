package com.abb;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "UserServlet",
        urlPatterns = "/users",
        initParams = {
                @WebInitParam(name = "name", value = "Ali"),
                @WebInitParam(name = "age", value = "27"),
                @WebInitParam(name = "job", value = "Developer")
        }
)
public class User extends HttpServlet {
    
    @Override
    protected void doGet (
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException {
        
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        
        try {
            Thread.sleep(3);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String counter = (String) getServletContext().getAttribute("requestCounter");
        int count = Integer.parseInt(counter) + 1;
        getServletContext().setAttribute("requestCounter", String.valueOf(count));
        
        String name = getInitParameter("name");
        String age = getInitParameter("age");
        String job = getInitParameter("job");
        
        resp.getWriter().write("Name: " + name + "\n");
        resp.getWriter().write("Age: " + age + "\n");
        resp.getWriter().write("Job: " + job + "\n");
        resp.getWriter().write("Request Counter: " + count);
        
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}