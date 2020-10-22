package com.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

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

    public void printAll() {
        if (this.collection.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            for (int i = 1; i < this.collection.size(); i++) {
                System.out.print(this.collection.get(i) + " ");
            }
            System.out.println();
        }

    }
}
