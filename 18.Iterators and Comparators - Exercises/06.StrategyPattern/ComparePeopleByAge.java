package com.company;

import java.util.Comparator;

public class ComparePeopleByAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Comparator.comparing(Person::getAge).compare(o1, o2);
    }
}
