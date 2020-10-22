package com.company;


import java.io.*;
import java.util.*;
import java.util.List;
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

        Function<Integer[], Integer> findTheSmallest = arr -> {
            int min = Integer.MAX_VALUE;

            for (Integer integer : arr) {
                if (integer < min) {
                    min = integer;
                }
            }

            return min;
        };

        System.out.println(findTheSmallest.apply(numbers));
    }
}

