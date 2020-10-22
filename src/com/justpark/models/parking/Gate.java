package com.justpark.models.parking;

import com.justpark.models.DBObject;

public abstract class Gate extends DBObject {
    private String gateName; //Gate2A, Gate3B
    private GateType type;
    abstract void open();
    abstract void close();

}

/*
Gate can change it's type, say after 11pm every entry gate is a exit gate, so we need have a Gatetype (not final)
for this functionality
 */
