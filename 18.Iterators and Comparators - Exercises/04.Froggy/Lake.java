package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake implements Iterable<Integer> {
    private int index;
    private Integer[] collection;
    private List<Integer> evenIndexes;
    private List<Integer> oddIndexes;

    public Lake(Integer[] collection) {
        this.collection = collection;
        this.index = 0;
        this.evenIndexes = new ArrayList<>();
        this.oddIndexes = new ArrayList<>();
    }

    public void printJumps() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < evenIndexes.size(); i++) {
            if (evenIndexes.size() == 1 && oddIndexes.size() == 0) {
                sb.append(evenIndexes.get(i));
            } else {
                sb.append(evenIndexes.get(i)).append(", ");
            }
        }
        for (int i = 0; i < oddIndexes.size(); i++) {
            if (i != oddIndexes.size() - 1) {
                sb.append(oddIndexes.get(i)).append(", ");
            } else {
                sb.append(oddIndexes.get(i));
            }
        }
        System.out.println(sb.toString());
    }

    public class Frog  implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return index < collection.length;
        }

        @Override
        public Integer next() {
            if (index % 2 == 0) {
                evenIndexes.add(collection[index]);
                index++;
                return collection[index - 1];
            } else {
                oddIndexes.add(collection[index]);
                index++;
                return collection[index - 1];
            }

        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
}
