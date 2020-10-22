package com.company;

import java.util.Comparator;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box(List<T> elements) {
        this.elements = elements;
    }


    public int compare(T item) {
        int result = 0;

        for (T t : this.elements) {
            if (t.compareTo(item) > 0) {
                result++;
            }
        }

        return result;
    }

    public List<T> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(element.getClass().getName() + ": " + element).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
