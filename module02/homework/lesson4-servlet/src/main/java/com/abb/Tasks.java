package com.abb;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "TaskServlet", urlPatterns = "/tasks")
public class Tasks extends HttpServlet {
    
    private String databasePath;
    
    @Override
    protected void doGet (
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException {
        
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        
        try {
            String content = Files.readString(Paths.get(databasePath), StandardCharsets.UTF_8);
            resp.getWriter().write(content);
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        catch (IOException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Failed to read tasks");
        }
    }
    
    @Override
    protected void doPost (
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException {
        
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        
        String task = req.getReader().lines().collect(Collectors.joining());
        Path filePath = Paths.get(databasePath);
        
        try {
            Files.writeString(
                    filePath,
                    task.trim() + System.lineSeparator(),
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            
            String content = Files.readString(filePath, StandardCharsets.UTF_8);
            
            resp.getWriter().write(content);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
        catch (IOException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Failed to add task");
        }
    }
    
    @Override
    protected void doDelete (
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException {
        
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        
        String lineParam = req.getParameter("line");
        
        if (lineParam == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Line parameter is required");
            return;
        }
        
        try {
            int lineNumber = Integer.parseInt(lineParam);
           
            Path filePath = Paths.get(databasePath);
           
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            
            if (lineNumber < 1 || lineNumber > lines.size()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Invalid line number!");
                return;
            }
            
            lines.remove(lineNumber - 1);
            Files.write(filePath, lines, StandardCharsets.UTF_8);
            
            String content = Files.readString(filePath, StandardCharsets.UTF_8);
            resp.getWriter().write(content);
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Invalid line number format");
        }
        catch (IOException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Something went wrong");
        }
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        databasePath = getServletContext().getRealPath("/WEB-INF/database.txt");
        
        if (databasePath == null) {
            String catalinaBase = System.getProperty("catalina.base");
            databasePath = catalinaBase + "/webapps/ROOT/WEB-INF/database.txt";
        }
        
        try {
            Path dbPath = Paths.get(databasePath);
            
            if (!Files.exists(dbPath)) {
                Files.createDirectories(dbPath.getParent());
                Files.createFile(dbPath);
                log("Created database file at: " + databasePath);
            }
        } catch (IOException e) {
            log("Failed to create database file: " + e.getMessage());
        }
        
        log("Task Servlet Started!");
        log("Database path: " + databasePath);
    }
}