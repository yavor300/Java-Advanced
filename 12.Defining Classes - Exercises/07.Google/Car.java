package com.company;

public class Car {
    private String model;
    private Integer speed;

    public Car(String model, Integer speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public Integer getSpeed() {
        return speed;
    }
}
