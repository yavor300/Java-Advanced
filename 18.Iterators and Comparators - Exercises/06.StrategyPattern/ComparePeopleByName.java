package com.company;

import java.util.Comparator;

public class ComparePeopleByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Comparator.comparing(Person::getNameLength).thenComparing(Person::getFirstLetter).compare(o1, o2);
    }
}
