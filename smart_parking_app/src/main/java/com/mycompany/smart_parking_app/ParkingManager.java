/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smart_parking_app;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */
public class ParkingManager {
    // variables
    private ArrayList<ParkingSpot> parkingSpots;
    NormalWaitingQueueInterface myNormalWaitingQueue;
    PriorityParkingQueue myPriorityParking;
    
    private int numberOfNormalParkingSpots;
    private int numberOfPriorityParkingSpots;
    
    
    // constructor
    public ParkingManager() {
        parkingSpots = new ArrayList<>();
        myNormalWaitingQueue = new NormalWaitingQueue();
        myPriorityParking = new PriorityParkingQueue();
        
        numberOfNormalParkingSpots = 5;
        numberOfPriorityParkingSpots = 3;
        
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
    
    
    // get the detailed information of reserved parking spots
    public String getDetailedInformationOfReservedParkingSpots() {
        String information = "";
        int count=0;
        
        for(int i=0; i<numberOfNormalParkingSpots; i++) {
            if(parkingSpots.get(i).getSpotType().equals("normal") && !parkingSpots.get(i).getIsAvaialbe()) {
                information += "parking spot " + (count+1) + " is secured by " + parkingSpots.get(i).getAssignedVehicle().getPlateNumber() + "\n";
                count++;
            }
            
        }
        
        information += "There are " + (numberOfNormalParkingSpots - count) + " spots availabe\n\n" + "number of waiting people : " + myNormalWaitingQueue.sizeForNormalWaiting() + "\n";
        
        return information;
    }
    
    
    // add normal parking
    public void normalEnqueue(Vehicle vehicle) {
        if(getAvailabeNormalParkingSpots() == 0) {
            JOptionPane.showMessageDialog(null, "Since we don't have any parking spots, you will be in the waiting queue\n"
                    + "If another driver cancel their reservation, you might take that place\n");
            
            myNormalWaitingQueue.enqueueForNormalWaiting(vehicle);        
        }
        else {
            for(int i=0; i<numberOfNormalParkingSpots; i++) {
                if(parkingSpots.get(i).getSpotType().equals("normal") && parkingSpots.get(i).getIsAvaialbe()) {
                    parkingSpots.get(i).setAssgignedVehicle(vehicle);
                    parkingSpots.get(i).setIsAvailable(false);
                    JOptionPane.showMessageDialog(null, "You successfully made a reservation!");
                    break;
                }
            }
        }
    }
    
    
    // search reserved car
    public String searchForNormalParking(String plateNumber) {
        String temp = "";
        for(int i=0; i<numberOfNormalParkingSpots; i++) {
            if(parkingSpots.get(i).getSpotType().equals("normal") && 
                    parkingSpots.get(i).getAssignedVehicle() != null &&
                    parkingSpots.get(i).getAssignedVehicle().getPlateNumber().equals(plateNumber)) {
                temp = "plate number: " + plateNumber + "\n" + "car type: "  + parkingSpots.get(i).getAssignedVehicle().getCarType() + "\n" + "disablility : " 
                        + parkingSpots.get(i).getAssignedVehicle().getIsDisabled() + "\n\n" + 
                        "Your parking spot: " + parkingSpots.get(i).getSpotId() + "\n\nYou successfully made a reservation\n";
                
                
                return temp;
            }
        }
        
        if(myNormalWaitingQueue.sizeForNormalWaiting()>0) {
            temp = myNormalWaitingQueue.searchNormalWaiting(plateNumber);
        }
        
        return temp;
    }
    
    
    // delete
    public String deleteForNormalParking(String plateNumber) {
        String temp = "";
        for(int i=0; i<numberOfNormalParkingSpots; i++) {
            if(parkingSpots.get(i).getSpotType().equals("normal") && 
                    parkingSpots.get(i).getAssignedVehicle() != null &&
                    parkingSpots.get(i).getAssignedVehicle().getPlateNumber().equals(plateNumber)) {
                
                temp = "plate number: " + plateNumber + "\n" + "car type: "  + parkingSpots.get(i).getAssignedVehicle().getCarType() + "\n" + "disablility : " 
                        + parkingSpots.get(i).getAssignedVehicle().getIsDisabled() + "\n\n" + 
                        "Your parking spot: " + parkingSpots.get(i).getSpotId() + "\n\nYour reservation has been cancelled.\n";
                
                
                Vehicle tempVehicle = (Vehicle) myNormalWaitingQueue.dequeueForNormalWaiting();
                if(tempVehicle!=null) {
                    parkingSpots.get(i).setAssgignedVehicle(tempVehicle);
                }
                else {
                    parkingSpots.get(i).setAssgignedVehicle(null);
                    parkingSpots.get(i).setIsAvailable(true);
                }
                return temp;
            }
        }
        
        if(myNormalWaitingQueue.sizeForNormalWaiting()>0) {
            temp = myNormalWaitingQueue.deleteNormalWaiting(plateNumber);
        }
        
        
        return temp;
    }
    
    
    public void priorityEnqueue(Vehicle vehicle) {
        int priorityKey = vehicle.getPriorityKey();
        
        myPriorityParking.enqueueForPriorityQueue(priorityKey, vehicle);
        
        ArrayList<PriroityQueueElement> list = myPriorityParking.getQueue();
        
        int j=0;
        for(int i = numberOfNormalParkingSpots; i<(numberOfNormalParkingSpots + numberOfPriorityParkingSpots); i++) {
            
            if(j < list.size()) {
                parkingSpots.get(i).setAssgignedVehicle((Vehicle) list.get(j).getVehicle());
                parkingSpots.get(i).setIsAvailable(false);
                j++;
            }
            else {
                parkingSpots.get(i).setAssgignedVehicle(null);
                parkingSpots.get(i).setIsAvailable(true);
            }
        }
        
        
        /*
        for(int i=numberOfNormalParkingSpots; i<(numberOfNormalParkingSpots + numberOfPriorityParkingSpots); i++) {
            PriroityQueueElement temp = (PriroityQueueElement) myPriorityParking.getPrioritQueueElement();
            Vehicle tempVehicle = (Vehicle) temp.getVehicle();
            
            parkingSpots.get(i).setAssgignedVehicle(tempVehicle);
            JOptionPane.showMessageDialog(null, "You successfully made a reservation!\n");
            break;
        }
        */
        /*
        for(int i=numberOfNormalParkingSpots; i<(numberOfNormalParkingSpots + numberOfPriorityParkingSpots); i++) {
            if(parkingSpots.get(i).getSpotType().equals("priority")) {
                PriroityQueueElement temp = (PriroityQueueElement) myPriorityParking.getPrioritQueueElement();
                Vehicle tempVehicle = (Vehicle) temp.getVehicle();
                        
                parkingSpots.get(i).setAssgignedVehicle(tempVehicle);
                parkingSpots.get(i).setIsAvailable(false);
                JOptionPane.showMessageDialog(null, "You successfully made a reservation!\n");
                break;
            }
            
        }
        */
    }
    
    public String getDetailedInformationOfPriorityParkingSpots() {
        String information = "";
        int count=0;
        
        for(int i=numberOfNormalParkingSpots; i<(numberOfNormalParkingSpots + numberOfPriorityParkingSpots); i++) {
            if(parkingSpots.get(i).getSpotType().equals("priority") && !parkingSpots.get(i).getIsAvaialbe()) {
                information += "parking spot " + (count+1) + " is secured by " + parkingSpots.get(i).getAssignedVehicle().getPlateNumber() + "\n";
                count++;
            }
            
        }
        
        information += "There are " + (numberOfPriorityParkingSpots - count) + " spots availabe\n\n";
        
        return information;
    }
}