/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smart_parking_app;

/**
 *
 * @author ABC
 */
public class PriroityQueueElement {
    
    private int key;
    private Object vehicle;
    
    public PriroityQueueElement(int key, Object vehicle) {
        this.key = key;
        this.vehicle = vehicle;
    }

    public int getKey() {
        return key;
    }

    public Object getVehicle() {
        return vehicle;
    }
    
    
}