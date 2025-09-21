package com.example.backend_springboot_task.controoler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_springboot_task.model.Driver;
import com.example.backend_springboot_task.repository.DriverRepo;


@RestController
public class DriverController {
    @Autowired
    DriverRepo drive_repo;


    // add (Create)
    @PostMapping("/drivers")
    public Driver addDriver(@RequestBody Driver driver){
        return this.drive_repo.save(driver);
    }

    // get all drivers
    @GetMapping("/drivers")
    public List<Driver> getAllDrivers(){
        return drive_repo.findAll();
    }

    @GetMapping("/drivers/{id}/history")
    public List<Integer> getDriver_assignedRoutes_Ids(@PathVariable("id") int id){
        return drive_repo.findById(id).get().getAssignedRoutes();
    }
     

}
