package com.abb.controller;

import com.abb.dto.CarDTO;
import com.abb.exception.CarNotFoundException;
import com.abb.repository.CarRepositoryImplementation;
import com.abb.service.CarService;
import com.abb.service.CarServiceImplementation;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "CarController", urlPatterns = "/cars")
public class CarController extends HttpServlet {
    
    private static final ObjectMapper om = new ObjectMapper();
    
    private CarService carService;
    
    @Override
    public void init () {
        carService = new CarServiceImplementation(new CarRepositoryImplementation());
    }
    
    @Override
    protected void doGet (
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException {
        resp.setContentType("application/json");
        
        String id = req.getParameter("id");
        
        String action = req.getParameter("action");

        try {
            if ("count".equals(action)) {
                int count = carService.count();

                resp.setStatus(200);
                resp.getWriter().println(om.writeValueAsString(count));
            }
            else if (id != null) {
                CarDTO car = carService.getCarById(Integer.parseInt(id));

                resp.setStatus(200);
                resp.getWriter().println(om.writeValueAsString(car));
            }
            else {
                var cars = carService.getCars();

                resp.setStatus(200);
                resp.getWriter().println(om.writeValueAsString(cars));
            }
        }
        catch (CarNotFoundException exception) {
            resp.setStatus(404);
            resp.getWriter().println("Car Not Found");
        }
        catch (Exception exception) {
            resp.setStatus(500);
            resp.getWriter().println("Internal Server Error");
        }
    }
    
    @Override
    protected void doPost (
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException {
        resp.setContentType("application/json");
        
        try {
            String requestBody = readRequestBody(req);
            CarDTO carDto = om.readValue(requestBody, CarDTO.class);
            
            carService.addCar(carDto);
            resp.setStatus(201);
        }
        catch (Exception exception) {
            resp.setStatus(400);
            resp.getWriter().println("Invalid Request");
        }
    }
    
    @Override
    protected void doPut (
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException {
        resp.setContentType("application/json");
        
        String id = req.getParameter("id");
        
        try {
            if (id == null) {
                resp.setStatus(400);
                resp.getWriter().println("Car ID is required");
                return;
            }
            
            String requestBody = readRequestBody(req);
            CarDTO carDto = om.readValue(requestBody, CarDTO.class);
            
            carService.updateCar(Integer.parseInt(id), carDto);
            resp.setStatus(204);
        }
        catch (CarNotFoundException exception) {
            resp.setStatus(404);
            resp.getWriter().println("Car Not Found");
        }
        catch (Exception exception) {
            resp.setStatus(400);
            resp.getWriter().println("Invalid Request");
        }
    }
    
    @Override
    protected void doDelete (
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException {
        resp.setContentType("application/json");
        
        String id = req.getParameter("id");
        
        try {
            if (id == null) {
                carService.deleteAll();
                resp.setStatus(204);
            }
            else {
                carService.deleteCarById(Integer.parseInt(id));
                resp.setStatus(204);
            }
        }
        catch (CarNotFoundException exception) {
            resp.setStatus(404);
            resp.getWriter().println("Car Not Found");
        }
        catch (Exception exception) {
            resp.setStatus(500);
            resp.getWriter().println("Internal Server Error");
        }
    }
    
    private String readRequestBody (HttpServletRequest req) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        
        try (BufferedReader bufferedReader = req.getReader()) {
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        }
        
        return sb.toString();
    }
}