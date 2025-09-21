package com.example.backend_springboot_task.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.Type;

import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.Column;  

@Entity
@Table(name = "driver")
public class Driver {
   @Id
    private int id;
    private String name;
    private String licenseType;
    private boolean availability ;
    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private List<Integer> assignedRoutes;
     

    Driver(){
        this.assignedRoutes = new ArrayList<>();
    }

    // setters
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setLicenseType(String licenseType){
        this.licenseType=licenseType;
    }
    public void setAvailability(boolean availability){
        this.availability=availability;
    }
    public void setAssignedRoutes(){
        this.assignedRoutes= new ArrayList<>();
    }
    public void addToAssignedRoutes(int RouteId){
        this.assignedRoutes.add(RouteId);
    }
    
    // getters
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getLicenseType(){
        return this.licenseType;
    }
    public boolean getAvailability(){
        return this.availability;
    }
    public List<Integer> getAssignedRoutes(){
        return this.assignedRoutes;
    }
}
