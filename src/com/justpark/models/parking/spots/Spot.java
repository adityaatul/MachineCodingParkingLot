package com.justpark.models.parking.spots;

public abstract class Spot {
    private final SpotType type;

    public Spot(SpotType type) {
        this.type = type;
    }
}
