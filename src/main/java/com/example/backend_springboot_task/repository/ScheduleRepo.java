package com.example.backend_springboot_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.backend_springboot_task.model.Schedule;

import jakarta.transaction.Transactional;

public interface ScheduleRepo extends JpaRepository<Schedule,Integer>{
    
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE schedule", nativeQuery = true)
    void truncateTable();

}
