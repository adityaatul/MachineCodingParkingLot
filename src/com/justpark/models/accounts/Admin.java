package com.justpark.models.accounts;

import com.justpark.models.electronics.Electronics;
import com.justpark.models.parking.Floor;
import com.justpark.models.parking.Gate;
import com.justpark.models.parking.spots.Spot;
import com.justpark.models.people.Person;

public class Admin extends Account {
    public Admin(String username, String saltedPasswordHash, Person person) {
        super(username, saltedPasswordHash, person);
    }

    void addFloor(Floor floor){

    }
    void removeFloor(Floor floor){

    }
    void modifyFloor(Floor floor){

    }
    void addSpot(Floor floor, Spot spot){

    }
    void removeSpot(Floor floor, Spot spot){

    }
    void modifySpot(Floor floor, Spot spot){

    }
    void addElectronics(Floor floor, Electronics electronic){

    }
    void removeElectronics(Floor floor, Electronics electronic){

    }
    void modifyElectronics(Floor floor, Electronics electronic){

    }
    void addGate(Gate spot){

    }
    void removeGate(Gate spot){

    }
    void modifyGate(Gate spot){

    }
}
