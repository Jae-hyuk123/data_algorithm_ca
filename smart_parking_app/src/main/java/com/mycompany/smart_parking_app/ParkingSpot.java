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
    private Vehicle AssgignedVehicle;
    
    // constructor
    public ParkingSpot(int spotId, String spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true;
    }
    
    
    // add
    public void assignVehicle(Vehicle vehicle) {
        this.AssgignedVehicle = vehicle;
        this.isAvailable = false;
    }
    
    // remove
    public void removeVehicle() {
        this.AssgignedVehicle = null;
        this.isAvailable = true;
    }
    
    
    public String getSpotType() {
        return spotType;
    }
    
    public boolean getIsAvaialbe() {
        return isAvailable;
    }
}
