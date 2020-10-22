package com.company;

import java.util.Comparator;

public class Sorter {

    public static void sort(CustomList<String> elements) {
        elements.getCollection().sort(Comparator.naturalOrder());
    }
}
