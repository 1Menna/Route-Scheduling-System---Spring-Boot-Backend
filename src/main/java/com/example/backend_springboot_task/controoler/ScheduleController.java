package com.example.backend_springboot_task.controoler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_springboot_task.model.Schedule;
import com.example.backend_springboot_task.services.ScheduleService;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService schedule_service;

    @GetMapping("/schedule")
    public List<Schedule> Scheduled_Data() {
        return this.schedule_service.recalculateSchedule();
    }
}
