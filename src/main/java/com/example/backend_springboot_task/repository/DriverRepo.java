package com.example.backend_springboot_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend_springboot_task.model.Driver;

public interface DriverRepo extends JpaRepository<Driver,Integer>{

    
}  