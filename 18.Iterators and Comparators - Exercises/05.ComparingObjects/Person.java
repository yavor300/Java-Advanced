package com.company;

import java.util.Comparator;

public class Person implements Comparator<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return Comparator.comparing(Person::getName).thenComparing(Person::getAge).thenComparing(Person::getTown).compare(o1, o2);
    }
}
