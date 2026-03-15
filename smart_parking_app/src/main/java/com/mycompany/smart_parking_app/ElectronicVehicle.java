package com.mycompany.smart_parking_app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ABC
 */
public class ElectronicVehicle extends Vehicle {
    
    public ElectronicVehicle(String plateNumber, boolean isDisabled, String carType){
        super(plateNumber, isDisabled, carType);
    }
    
    @Override
    public int getPriorityLevel() {
        return 0;   // need to be fixed
    }
}
