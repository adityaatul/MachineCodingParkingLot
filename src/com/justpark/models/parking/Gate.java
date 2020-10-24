package com.justpark.models.parking;

import com.justpark.models.electronics.AutoExitPanel;
import com.justpark.models.DBObject;
import com.justpark.models.accounts.Attendant;
import com.justpark.models.parking.interfaces.PaymentEnabled;

public class Gate extends DBObject implements PaymentEnabled {
    private String gateName; //Gate2A, Gate3B
    private GateType type;
    private Attendant attendant;
    private AutoExitPanel exitPanel;

    void open() {

    }

    void close() {

    }

    @Override
    public void processTicket(Ticket ticket) {

    }

    @Override
    public void processPayment() {

    }
}

/*
Gate can change it's type, say after 11pm every entry gate is a exit gate, so we need have a Gatetype (not final)
for this functionality
 */
