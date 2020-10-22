package com.company;

public class Cargo {
    private Integer weight;
    private String type;

    public Cargo(Integer weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}
