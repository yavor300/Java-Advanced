package com.company;

public class Tire {
    private Double pressure;
    private Integer age;

    public Tire(Double pressure, Integer age) {
        this.pressure = pressure;
        this.age = age;
    }

    public Double getPressure() {
        return pressure;
    }

    public Integer getAge() {
        return age;
    }
}
