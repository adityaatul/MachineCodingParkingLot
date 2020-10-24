package com.justpark.exceptions;

public class SpotAlreadyOccupiedExpection extends Throwable {
    public SpotAlreadyOccupiedExpection(String message) {
        super(message);
    }
}
