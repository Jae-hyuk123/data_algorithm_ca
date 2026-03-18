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
    protected int priorityKye;
    
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
    
    public int getPriorityKey() {
        if(isDisabled) {
            return 3;
        }
        else if(carType.equals("electronic")) {
            return 2;
        }
        else {
            return 1;
        }
    }
}
