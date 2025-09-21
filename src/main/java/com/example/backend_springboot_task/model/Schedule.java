package com.example.backend_springboot_task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int routeId;
    private int driverId;
    private String driverName;

    // setters
    public void setId(int id){
        this.id = id;
    }
    public void setRouteId(int routeId){
        this.routeId = routeId;
    }
    public void setDriverId(int driverId){
        this.driverId = driverId;
    }
    public void setDriverName(String driverName){
        this.driverName=driverName;
    }
     
   
    
    // getters
    public int getId(){
        return this.id;
    }
    public int getRouteId(){
        return this.routeId;
    }
    public int getDriverId(){
        return this.driverId;
    }
    public String getDriverName(){
        return this.driverName;
    }
     

}
