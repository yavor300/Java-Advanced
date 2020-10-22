package com.company;

public class Engine {
    private Integer speed;
    private Integer power;

    public Engine(Integer speed, Integer power) {
        this.speed = speed;
        this.power = power;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getPower() {
        return power;
    }
}
