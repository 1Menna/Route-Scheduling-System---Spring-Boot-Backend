package com.example.backend_springboot_task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_springboot_task.model.Driver;
import com.example.backend_springboot_task.model.Route;
import com.example.backend_springboot_task.model.Schedule;
import com.example.backend_springboot_task.repository.DriverRepo;
import com.example.backend_springboot_task.repository.RouteRepo;
import com.example.backend_springboot_task.repository.ScheduleRepo;

@Service
public class ScheduleService {

    @Autowired
    private DriverRepo drive_repo;

    @Autowired
    private RouteRepo route_repo;

    @Autowired
    private ScheduleRepo schedule_repo;

    public List<Schedule> recalculateSchedule() {

        // Clear all previous schedule entries
        schedule_repo.truncateTable();

        // Reset all drivers to available
        List<Driver> drivers = drive_repo.findAll();
        for (Driver driver : drivers) {
            driver.setAvailability(true);
            driver.getAssignedRoutes().clear(); 
        }
        drive_repo.saveAll(drivers);  // save all updated drivers at once

        drivers = drive_repo.findAll();
        List<Route> routes = route_repo.findAll();

        for (Route route : routes) {

            for (Driver driver : drivers) {
                if (driver.getAvailability()) {
                    // Assign driver to this route
                    Schedule s = new Schedule();
                    s.setRouteId(route.getId());
                    s.setDriverName(driver.getName());
                    s.setDriverId(driver.getId()); 
                    schedule_repo.save(s);
                    // add this route to its assignedRoutes
                    driver.addToAssignedRoutes(route.getId());
                    // Make driver unavailable
                    driver.setAvailability(false);
                    break;
                }
            }

        }

        // Save updated driver availability after assignments
        drive_repo.saveAll(drivers);

        return schedule_repo.findAll();
    }
}
