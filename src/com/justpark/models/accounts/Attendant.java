package com.justpark.models.accounts;

import com.justpark.models.parking.Ticket;
import com.justpark.models.parking.interfaces.IssueTicket;
import com.justpark.models.parking.interfaces.PaymentEnabled;
import com.justpark.models.people.Person;

public class Attendant extends Account implements IssueTicket, PaymentEnabled {
    public Attendant(String username, String saltedPasswordHash, Person person) {
        super(username, saltedPasswordHash, person);
    }

    @Override
    public void processTicket(Ticket ticket) {

    }

    @Override
    public void processPayment() {

    }

    @Override
    public Ticket giveTicket() {
        return null;
    }
}
