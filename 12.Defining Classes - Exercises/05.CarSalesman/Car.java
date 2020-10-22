package com.company;

public class Car {
    private String model;
    private Engine engine;
    private Integer weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.weight == null && this.engine.getDisplacement() == null) {
            sb.append(String.format("%s:%n%s:%nPower: %d%nDisplacement: n/a%nEfficiency: %s%nWeight: n/a%nColor: %s%n",
                    this.getModel(), this.getEngine().getModel(), this.getEngine().getPower(), this.getEngine().getEfficiency(), this.getColor()));
        } else if (this.weight == null) {
            sb.append(String.format("%s:%n%s:%nPower: %d%nDisplacement: %d%nEfficiency: %s%nWeight: n/a%nColor: %s%n",
                    this.getModel(), this.getEngine().getModel(), this.getEngine().getPower(), this.getEngine().getDisplacement(),this.getEngine().getEfficiency(), this.getColor()));
        } else if (this.engine.getDisplacement() == null) {
            sb.append(String.format("%s:%n%s:%nPower: %d%nDisplacement: n/a%nEfficiency: %s%nWeight: %d%nColor: %s%n",
                    this.getModel(), this.getEngine().getModel(), this.getEngine().getPower(), this.getEngine().getEfficiency(), this.getWeight(),this.getColor()));
        } else {
            sb.append(String.format("%s:%n%s:%nPower: %d%nDisplacement: %d%nEfficiency: %s%nWeight: %d%nColor: %s%n",
                    this.getModel(), this.getEngine().getModel(), this.getEngine().getPower(), this.getEngine().getDisplacement(),this.getEngine().getEfficiency(), this.getWeight(),this.getColor()));
        }
        return sb.toString();
    }
}
