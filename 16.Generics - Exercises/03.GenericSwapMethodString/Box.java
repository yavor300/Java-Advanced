package com.company;

public class Box<T> {
    private T[] elements;

    public Box(T[] elements) {
        this.elements = elements;
    }

    public void swap(int firstIndex, int secondIndex) {
        if (validateIndex(firstIndex) && validateIndex(secondIndex)) {
            T firstElement = this.elements[firstIndex];
            this.elements[firstIndex] = this.elements[secondIndex];
            this.elements[secondIndex] = firstElement;
        }
    }

    private boolean validateIndex(int index) {
        return index >= 0 && index < this.elements.length;
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
