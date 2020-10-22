package com.company;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return this.name.length();
    }

    public char getFirstLetter() {
        return Character.toLowerCase(this.name.charAt(0));
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
