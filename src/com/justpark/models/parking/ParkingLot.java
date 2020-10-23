package com.justpark.models.parking;

import com.justpark.models.electronics.EntrancePanel;
import com.justpark.models.people.Address;

import java.util.List;

public class ParkingLot {
    List<Floor> floors;
    List<Gate> gates;
    EntrancePanel entrancePanel;
    Address address;

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public EntrancePanel getEntrancePanel() {
        return entrancePanel;
    }

    public void setEntrancePanel(EntrancePanel entrancePanel) {
        this.entrancePanel = entrancePanel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
