package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> collection;

    public CustomList() {
        this.collection = new ArrayList<>();
    }

    public void add(T element) {
        this.collection.add(element);
    }

    public T remove(int index) {
        T result = null;
        if (validateIndex(index) && !this.collection.isEmpty()) {
            result = this.collection.remove(index);
        }
        return result;
    }

    public boolean contains(T element) {
        return this.collection.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (validateIndex(firstIndex) && validateIndex(secondIndex) && !this.collection.isEmpty()) {
            T firstElement = this.collection.get(firstIndex);
            this.collection.set(firstIndex, this.collection.get(secondIndex));
            this.collection.set(secondIndex, firstElement);

        }
    }

    public int countGreaterThan(T element) {
        int result = 0;
        if (!this.collection.isEmpty()) {
            for (T t : this.collection) {
                if (t.compareTo(element) > 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public T getMax() {
        T result = null;
        if (!this.collection.isEmpty()) {
            result = Collections.max(this.collection);
        }
        return result;
    }

    public T getMin() {
        T result = null;
        if (!this.collection.isEmpty()) {
            result = Collections.min(this.collection);
        }
        return result;
    }

    @Override
    public String toString() {
        if (!this.collection.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (T t : this.collection) {
                sb.append(t).append(System.lineSeparator());
            }
            return sb.toString().trim();
        }
        return null;
    }

    private boolean validateIndex(int index) {
        return index >= 0 && index < this.collection.size();
    }
}




