package com.mycompany.smart_parking_app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author ABC
 */
public interface NormalWaitingQueueInterface {
    public boolean isEmptyForNormalWaiting();
    
    public int sizeForNormalWaiting();
    
    public Object frontElementForNormalWaiting();
    
    public void enqueueForNormalWaiting(Object vehicle);
    
    public Object dequeueForNormalWaiting();
    
    public String searchNormalWaiting(String plateNumber);
    
    public String deleteNormalWaiting(String plateNumber);
}
