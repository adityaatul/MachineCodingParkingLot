package com.justpark.models.people;

import com.justpark.models.DBObject;
import com.justpark.models.accounts.Account;

import java.lang.management.BufferPoolMXBean;

public class Person extends DBObject {
    private String name;
    private Address address;
    private String phoneNumber;
    private  Account account;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.account = builder.account;
    }
    public static final class PersonBuilder {
        private String name;
        private Address address;
        private String phoneNumber;
        private Account account;
        //If we want to specify one field in the builder that this must be present
        //we can specify that field in Builder constructor
        //also we can enforce this in the build function.
        //i.e createPerson

        public PersonBuilder(String name){
            this.name = name;
        }

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public PersonBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public PersonBuilder setAccount(Account account) {
            this.account = account;
            return this;
        }

        public Person createPerson() {
            return new Person(this);
        }
    }
}
