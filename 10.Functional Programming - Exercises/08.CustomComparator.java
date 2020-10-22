package com.company;


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Main {

    public static Integer[] parseLineOfNumbers(String line) {
        String[] numberString = line.split(" ");
        Integer[] numbers = new Integer[numberString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberString[i]);
        }
        return numbers;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = parseLineOfNumbers(bfr.readLine());

        Comparator<Integer> ascendingComparator = Integer::compareTo;


        Function<Integer[], String> orderNumbers = arr -> {
            StringBuilder sb = new StringBuilder();

            List<Integer>  evenNumbers = new ArrayList<>();
            List<Integer> oddNumbers = new ArrayList<>();

            for (Integer integer : arr) {
                if (integer % 2 == 0) {
                    evenNumbers.add(integer);
                } else {
                    oddNumbers.add(integer);
                }
            }

            evenNumbers.sort(ascendingComparator);
            oddNumbers.sort(ascendingComparator);

            if (!evenNumbers.isEmpty()) {
                for (Integer evenNumber : evenNumbers) {
                    sb.append(evenNumber).append(" ");
                }
            }
            if (!oddNumbers.isEmpty()) {
                for (Integer oddNumber : oddNumbers) {
                    sb.append(oddNumber).append(" ");
                }

            }
            return sb.toString();
        };

        System.out.println(orderNumbers.apply(numbers));

    }
}

