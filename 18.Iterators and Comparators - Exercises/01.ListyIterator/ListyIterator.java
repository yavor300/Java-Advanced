package com.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator {

    private int index;
    private List<String> collection;

    public ListyIterator(String... elements) {
        this.collection = Arrays.asList(elements);
        this.index = 1;
    }


    public boolean move() {
        if (this.index + 1 < this.collection.size()) {
            this.index++;
            return true;
        }
        return  false;
    }

    public boolean hasNext() {
        return this.index + 1 < this.collection.size();
    }

    public void print() {
        if (this.collection.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.collection.get(index));
        }
    }
}
