package com.justpark;

import com.justpark.models.people.Address;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World!");
        Address a =  new Address.AddressBuilder()
                .setCountry("India")
                .setState("Karnataka")
                .setCity("Bangalore")
                .setStreetAddress("B5611 Brigade Medows")
                .setZipcode("560082")
                .build();
    }
}
