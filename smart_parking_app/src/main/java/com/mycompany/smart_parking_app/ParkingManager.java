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
public class ParkingManager {
    // variables
    private ArrayList<ParkingSpot> parkingSpots;
    private int numberOfNormalParkingSpots;
    private int numberOfPriorityParkingSpots;
    
    // constructor
    public ParkingManager() {
        parkingSpots = new ArrayList<>();
        
        numberOfNormalParkingSpots = 70;
        numberOfPriorityParkingSpots = 30;
        
        // 70 normal parking spots 
        for(int i=1; i<numberOfNormalParkingSpots+1; i++) {
            parkingSpots.add(new ParkingSpot(i, "normal"));
        }
        
        // 30 priority parking spots
        for(int i=(numberOfNormalParkingSpots+1); i<(numberOfNormalParkingSpots + numberOfPriorityParkingSpots)+1; i++) {
            parkingSpots.add(new ParkingSpot(i, "priority"));
        }
    }
    
    // get the number of avaialbe normal parking spots
    public int getAvailabeNormalParkingSpots() {
        String spotType;
        int count=0;
        
        for(int i=0; i<numberOfNormalParkingSpots; i++) {
            if(parkingSpots.get(i).getSpotType().equals("normal") && parkingSpots.get(i).getIsAvaialbe()) {
                count++;
            }
        }
        
        return count;
    }
    
    
    // get the number of avaialbe priority parking spots
    public int getAvaiablePriorityParkingSpots() {
        String spotType;
        int count=0;
        
        for(int i=numberOfNormalParkingSpots; i<parkingSpots.size(); i++) {
            if(parkingSpots.get(i).getSpotType().equals("priority") && parkingSpots.get(i).getIsAvaialbe()) {
                count++;
            }
        }
        
        return count;
    }
}
