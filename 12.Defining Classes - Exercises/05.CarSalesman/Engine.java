package com.company;

public class Engine {
    private String model;
    private Integer power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model, Integer power) {
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
