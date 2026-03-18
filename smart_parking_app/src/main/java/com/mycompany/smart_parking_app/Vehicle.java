/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smart_parking_app;

/**
 *
 * @author ABC
 */
abstract class Vehicle {
    protected String plateNumber;
    protected boolean isDisabled;
    protected String carType;
    
    public Vehicle(String plateNumber, boolean isDisabled, String carType){
        this.plateNumber = plateNumber;
        this.isDisabled = isDisabled;
        this.carType = carType;
    }
    
    // getter
    public String getPlateNumber() {
        return plateNumber;
    }
    
    public String getCarType() {
        return carType;
    }
    
    public boolean getIsDisabled() {
        return isDisabled;
    }
    
    public abstract int getPriorityLevel();
}
