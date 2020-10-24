package com.justpark.models.parking.spots;

import com.justpark.exceptions.MalformedVehicalException;
import com.justpark.exceptions.SpotAlreadyFreeExpection;
import com.justpark.exceptions.SpotAlreadyOccupiedExpection;
import com.justpark.models.DBObject;
import com.justpark.models.vehicles.Vehicle;

public abstract class Spot extends DBObject {
    private final SpotType type;
    private SpotStatus status;
    private Vehicle vehicle;

    public Spot(SpotType type) {
        this.type = type;
    }
    public SpotType getType() {
        return type;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public void park(Vehicle vehicle) throws SpotAlreadyOccupiedExpection, MalformedVehicalException {
        if(!status.equals(SpotStatus.FREE)){
            throw new SpotAlreadyOccupiedExpection(this.toString()+ "is already occupied!");
        }
        if(vehicle.getType().getFitsIn().contains(this.getType())){
            throw new MalformedVehicalException(vehicle.getType()+ " doesn't fits in "+this.toString());
        }
        this.vehicle = vehicle;
        this.status = SpotStatus.OCCUPIED;
    }

    public Vehicle unPark() throws SpotAlreadyFreeExpection {
        if(!status.equals(SpotStatus.FREE)){
            throw new SpotAlreadyFreeExpection(this.toString()+ " is already free!");
        }
        Vehicle vehicle = this.vehicle;
        this.vehicle = null;
        status = SpotStatus.FREE;
        return vehicle;
    }

}
