/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.smart_parking_app;

import java.util.ArrayList;

/**
 *
 * @author ABC
 */
public interface PriorityInterface {
    public boolean isEmptyForPriorityQueue();
    
    public int sizeForPriorityQueue();
    
    public void enqueueForPriorityQueue(int priorityKey, Object vehicle);
    
    public int findInsertPosition(int iNewPriorityKey);
    
    public Object dequeueForPriorityQueue();
    
    public String deletePriorityQueue(String plateNumber);
    
    public String searchPriorityQueue(String plateNumber, int numberOfPriorityParkingSpots);
    
    public ArrayList<PriroityQueueElement> getQueue();
}
