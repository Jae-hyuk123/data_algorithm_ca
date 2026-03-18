/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smart_parking_app;

/**
 *
 * @author ABC
 */
public class ParkingSpot {
    // variables
    private int spotId;
    private String spotType;    // normal or priority
    private boolean isAvailable;
    private Vehicle AssignedVehicle;
    
    // constructor
    public ParkingSpot(int spotId, String spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true;
    }
    
    
    // add
    public void assignVehicle(Vehicle vehicle) {
        this.AssignedVehicle = vehicle;
        this.isAvailable = false;
    }
    
    // remove
    public void removeVehicle() {
        this.AssignedVehicle = null;
        this.isAvailable = true;
    }
    
    // getter
    public String getSpotType() {
        return spotType;
    }
    
    public boolean getIsAvaialbe() {
        return isAvailable;
    }
    
    public Vehicle getAssignedVehicle() {
        return AssignedVehicle;
    }
    
    public int getSpotId() {
        return spotId;
    }
    
    // setter
    public void setAssgignedVehicle(Vehicle AssignedVehicle) {
        this.AssignedVehicle = AssignedVehicle;
    }
    
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
}   
