package com.justpark.models.people;

public class Address {
    private String country;
    private String state;
    private String city;
    private String streetAddress;
    private String zipcode;

    //Should be private , so that constructor is not accessible from outside.
    /*
    1. Order of param .
    2. Omit for later, let's say one value is available to use after the user pass it,etc, etc.
    3. Default Value/ Missing Value
     */
    private Address(AddressBuilder builder) {
        this.country = builder.country;
        this.state = builder.state;
        this.city = builder.city;
        this.zipcode = builder.zipcode;
        this.streetAddress = builder.streetAddress;
    }

    public static final class AddressBuilder {
        private String country;
        private String state;
        private String city;
        private String zipcode;
        private String streetAddress;

        public AddressBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public AddressBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder setZipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public AddressBuilder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Address build() {
            if(this.country==null){
                this.setCountry("default_country");
            }
            return new Address(this);
        }
    }
}

