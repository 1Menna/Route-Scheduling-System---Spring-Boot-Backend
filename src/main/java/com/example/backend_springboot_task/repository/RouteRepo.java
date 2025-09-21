package com.example.backend_springboot_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend_springboot_task.model.Route;

public interface RouteRepo extends JpaRepository<Route,Integer>{

    
}  