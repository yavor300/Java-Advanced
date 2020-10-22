package com.company;


import java.io.*;
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

        Function<Integer[], Integer> findSmallestIndex = arr -> {
            int resultIndex = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= min) {
                    min = arr[i];
                    resultIndex = i;
                }
            }
            return resultIndex;
        };

        System.out.println(findSmallestIndex.apply(numbers));

    }
}

