package com.example.backend_springboot_task.controoler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_springboot_task.model.Route;
import com.example.backend_springboot_task.repository.RouteRepo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
public class RouteController {
    @Autowired
    RouteRepo route_repo;


    // add Route
    @PostMapping("/routes")
    public Route addRoute(@RequestBody Route route){
        return this.route_repo.save(route);
    }

    // get all routes
    @GetMapping("/routes")
    public Page<Route> getAllRoutes(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size) {
        return route_repo.findAll(PageRequest.of(page, size));
    }
    

    
}
