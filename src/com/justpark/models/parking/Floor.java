package com.justpark.models.parking;

import com.justpark.exceptions.MalformedVehicalException;
import com.justpark.exceptions.SpotAlreadyFreeExpection;
import com.justpark.exceptions.SpotAlreadyOccupiedExpection;
import com.justpark.exceptions.SpotNotAddedExpection;
import com.justpark.models.electronics.CustomerInfoPortal;
import com.justpark.models.electronics.DisplayBoard;
import com.justpark.models.parking.spots.Spot;
import com.justpark.models.parking.spots.SpotStatus;
import com.justpark.models.parking.spots.SpotType;
import com.justpark.models.vehicles.Vehicle;

import java.util.*;

public class Floor {
    private CustomerInfoPortal customerInfoPortal;
    private Map<SpotType, Set<Spot>> freeSpot;
    private Map<SpotType, Set<Spot>> occupiedSpot;
    private DisplayBoard displayBoard;
    private String name;

    public Floor(String name) {
        setName(name);
        displayBoard = new DisplayBoard();
        freeSpot = new HashMap<>();
        occupiedSpot = new HashMap<>();
        customerInfoPortal = new CustomerInfoPortal();
    }
    public void addSpot(Spot spot) throws SpotAlreadyOccupiedExpection {
        populateMap(spot.getType());
        if (!spot.getStatus().equals(SpotStatus.FREE) || occupiedSpot.get(spot.getType()).contains(spot)){
            throw new SpotAlreadyOccupiedExpection("Can't add spot "+spot.toString()+" already occupied!");
        }
        freeSpot.get(spot.getType()).add(spot);
    }

    private void populateMap(SpotType type) {
        if(freeSpot.containsKey(type)){
            freeSpot.put(type,new HashSet<>());
        }
        if(occupiedSpot.containsKey(type)){
            occupiedSpot.put(type,new HashSet<>());
        }
    }

    public synchronized void park(Spot spot,Vehicle vehicle) throws SpotAlreadyOccupiedExpection, MalformedVehicalException, SpotNotAddedExpection {
        //The ground floor has the responsibility to find a free spot/ ground floor?
        populateMap(spot.getType());
        if(!freeSpot.get(spot.getType()).contains(spot)){
            throw new SpotNotAddedExpection("Spot must be added to floor before it can be used to park!");
        }
        spot.park(vehicle);
        freeSpot.get(spot.getType()).remove(spot);
        occupiedSpot.get(spot.getType()).add(spot);
        updateDisplayBoard();

    }
    //adding sync for thread safe.
    public synchronized Vehicle unPark(Spot spot) throws SpotAlreadyFreeExpection, SpotNotAddedExpection {
        populateMap(spot.getType());
        if(!freeSpot.get(spot.getType()).contains(spot))
            throw new SpotNotAddedExpection("Spot must be added to floor before it can be unparked!");
        Vehicle vehicle = spot.unPark();
        occupiedSpot.get(spot.getType()).remove(spot);
        freeSpot.get(spot.getType()).add(spot);
        updateDisplayBoard();
        return vehicle;
    }

    private void updateDisplayBoard() {
        StringBuilder message = new StringBuilder();
        for (SpotType type:freeSpot.keySet()) {
            Set<Spot> spots = freeSpot.get(type);
            message.append("\n ").append(type.toString()).append(" :");
            if(spots.size()==0){
                message.append("No free spots!");
            }
            message.append(spots.iterator().next().toString());
        }
        displayBoard.showMessage(message.toString());
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
