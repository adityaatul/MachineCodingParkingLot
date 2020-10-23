package com.justpark.models.accounts;

import com.justpark.models.people.Person;

//Can exist and can not if we don't want to have the pass system
public class Customer extends Account {
    public Customer(String username, String saltedPasswordHash, Person person) {
        super(username, saltedPasswordHash, person);
    }
}
