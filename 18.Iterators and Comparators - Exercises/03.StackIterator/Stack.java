package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack implements Iterable<Integer> {
    private int index;
    private List<Integer> collection;

    public Stack() {
        this.collection = new ArrayList<>();
        this.index = this.collection.size() - 1;
    }

    public void push(int element) {
        this.collection.add(element);
        this.index++;
    }

    public void pop() {
        if (this.collection.isEmpty()) {
            System.out.println("No elements");
        } else {
            this.collection.remove(index);
            this.index--;
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Integer> getCollection() {
        return collection;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                return collection.get(index--);
            }
        };
    }
}
