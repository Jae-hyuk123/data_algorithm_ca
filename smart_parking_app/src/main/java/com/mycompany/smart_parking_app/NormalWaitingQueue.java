/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smart_parking_app;

import java.util.ArrayList;

/**
 *
 * @author ABC
 */
public class NormalWaitingQueue {
    private ArrayList<Vehicle> normalWaitingQueue;
    
    public NormalWaitingQueue() {
        normalWaitingQueue = new ArrayList<>();
    }
    
    public boolean isEmptyForNormalWaiting() {
        return normalWaitingQueue.isEmpty();
    }
    
    public int sizeForNormalWaiting() {
        return normalWaitingQueue.size();
    }
    
    public Object frontElementForNormalWaiting() {
        if (normalWaitingQueue.size() > 0) {
            return normalWaitingQueue.get(0);
        } else {
            return null;
        }
    }
    
    public void enqueueForNormalWaiting(Object vehicle) {
        normalWaitingQueue.add((Vehicle) vehicle);
    }
    
    public Object dequeueForNormalWaiting() {
        if (normalWaitingQueue.size() > 0) {
            return normalWaitingQueue.remove(0);
        } else {
            return null;
        }
    }
    
    public String searchNormalWaiting(String plateNumber) {
        String message = "";
        for(int i=0; i<sizeForNormalWaiting(); i++) {
            if(plateNumber.equals(normalWaitingQueue.get(i).getPlateNumber())) {
                message = "Your are currently number " + (i+1) + " in line.\n";
                break;
            }
        }
        
        return message;
    }
    
    public String deleteNormalWaiting(String plateNumber) {
        String message = "";
        for(int i=0; i<sizeForNormalWaiting(); i++) {
            if(plateNumber.equals(normalWaitingQueue.get(i).getPlateNumber())) {
                message = "Your waiting reservation has been successfully cancelled.\n";
                normalWaitingQueue.remove(i);
                break;
            }
        }
        
        return message;
    }
}
