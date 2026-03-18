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
public class PriorityParkingQueue implements PriorityInterface{
    
    private ArrayList<PriroityQueueElement> myPriorityQueue;

    public PriorityParkingQueue() {
        myPriorityQueue = new ArrayList<PriroityQueueElement>();
    }
    
    @Override
    public boolean isEmptyForPriorityQueue() {
        return myPriorityQueue.isEmpty();
    }
     
    @Override
    public int sizeForPriorityQueue() {
        return myPriorityQueue.size();
    }
    
    @Override
    public void enqueueForPriorityQueue(int priorityKey, Object vehicle) {
        int index;
        PriroityQueueElement temp = new PriroityQueueElement(priorityKey, vehicle);

        index = findInsertPosition(priorityKey);

        if (index > sizeForPriorityQueue()) {
            myPriorityQueue.add(temp);
        } else {
            myPriorityQueue.add(index, temp);
        }
    }
    
    @Override
    public int findInsertPosition(int iNewPriorityKey) {
        PriroityQueueElement curElement;
        
        int index;

        for (index = 0; index < myPriorityQueue.size(); index++) {
            curElement = myPriorityQueue.get(index);
            if (curElement.getKey() < iNewPriorityKey) {
                break;
            }
        }
        
        return index;
    }
    
    @Override
    public Object dequeueForPriorityQueue() {
        return myPriorityQueue.remove(0);
    }
    
    @Override
    public String deletePriorityQueue(String plateNumber) {
        String message = "";
        for(int i=0; i<myPriorityQueue.size(); i++) {
            Vehicle temp = (Vehicle) myPriorityQueue.get(i).getVehicle();
            
            if(temp.getPlateNumber().equals(plateNumber)) {
                message = "Your reservation has been canceled.\n";
                
                myPriorityQueue.remove(i);
                break;
            }
        }
        return message;
    }
    
    @Override
    public String searchPriorityQueue(String plateNumber, int numberOfPriorityParkingSpots) {
        String message = "";
        for(int i=0; i<myPriorityQueue.size(); i++) {
            Vehicle temp = (Vehicle) myPriorityQueue.get(i).getVehicle();
            
            if(temp.getPlateNumber().equals(plateNumber)) {
                message = "You are currently in number " + ((i+1)-numberOfPriorityParkingSpots) + " in line for priority park.";
                break;
            }
        }
        return message;
    }
    
    @Override
    public ArrayList<PriroityQueueElement> getQueue() {
        return myPriorityQueue;
    }
}
