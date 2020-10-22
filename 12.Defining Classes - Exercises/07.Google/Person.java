package com.company;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemon() {
        return pokemons;
    }

    public void setPokemon(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(System.lineSeparator());
        
        sb.append("Company:").append(System.lineSeparator());
        if (this.getCompany() != null) {
            sb.append(String.format("%s %s %.2f", this.getCompany().getName(), this.getCompany().getDepartment(), this.getCompany().getSalary()))
                    .append(System.lineSeparator());
        }
        
        sb.append("Car:").append(System.lineSeparator());
        if (this.getCar() != null) {
            sb.append(String.format("%s %d", this.getCar().getModel(), this.getCar().getSpeed()))
                    .append(System.lineSeparator());
        }
        
        sb.append("Pokemon:").append(System.lineSeparator());
        if (this.getPokemon().size() != 0) {
            for (Pokemon pokemon : this.getPokemon()) {
                sb.append(String.format("%s %s", pokemon.getName(), pokemon.getType()))
                        .append(System.lineSeparator());
            }
        }
        
        sb.append("Parents:").append(System.lineSeparator());
        if (this.getParents().size() != 0) {
            for (Parent parent : this.getParents()) {
                sb.append(String.format("%s %s", parent.getName(), parent.getBirthday()))
                        .append(System.lineSeparator());
            }

        }
        
        sb.append("Children:").append(System.lineSeparator());
        if (this.getChildren().size() != 0) {
            for (Child child : this.getChildren()) {
                sb.append(String.format("%s %s", child.getName(), child.getBirthday()))
                        .append(System.lineSeparator());
            }

        }
        return sb.toString();
    }
}
