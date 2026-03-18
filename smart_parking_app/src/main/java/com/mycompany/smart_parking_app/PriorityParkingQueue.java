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
public class PriorityParkingQueue {
    
    private ArrayList<PriroityQueueElement> myPriorityQueue;

    public PriorityParkingQueue() {
        myPriorityQueue = new ArrayList<PriroityQueueElement>();
    }
    
     public boolean isEmptyForPriorityQueue() {
        return myPriorityQueue.isEmpty();
    }
     
    public int sizeForPriorityQueue() {
        return myPriorityQueue.size();
    }
    
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
    
    private int findInsertPosition(int iNewPriorityKey) {
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
    
    public Object dequeueForPriorityQueue() {
        return myPriorityQueue.remove(0);
    }
    
    public ArrayList<PriroityQueueElement> getQueue() {
        return myPriorityQueue;
    }
}
