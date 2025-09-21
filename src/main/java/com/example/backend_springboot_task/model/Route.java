package com.example.backend_springboot_task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String startLocation;
    private String endLocation;
    private double distance;
    private double estimatedTime;

    // setters
    public void setId(int id){
        this.id = id;
    }
    public void setStartLocation(String startLocation){
        this.startLocation=startLocation;
    }
    public void setEndLocation(String endLocation){
        this.endLocation=endLocation;
    }
    public void setDistance(double distance){
        this.distance=distance;
    }
    public void setEstimatedTime(double estimatedTime){
        this.estimatedTime=estimatedTime;
    }
   
    
    // getters
    public int getId(){
        return this.id;
    }
    public String getStartLocation(){
        return this.startLocation;
    }
    public String getEndLocation(){
        return this.endLocation;
    }
    public double getDistance(){
        return this.distance;
    }
    public double getEstimatedTime(){
        return this.estimatedTime;
    }
     
}
