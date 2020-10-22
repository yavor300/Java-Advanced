package com.company;


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

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

        int n = Integer.parseInt(bfr.readLine());
        Integer[] divisors = parseLineOfNumbers(bfr.readLine());

        BiPredicate<Integer, Integer> checkForDivision = (num1, num2) -> num1 % num2 == 0;
        Predicate<List<Boolean>> isNotDivisible = list -> list.contains(false);

        for (int i = 1; i <= n; i++) {
            List<Boolean> resultsFromDivision = new ArrayList<>();
            for (Integer divisor : divisors) {
                resultsFromDivision.add(checkForDivision.test(i, divisor));
            }
            if (!isNotDivisible.test(resultsFromDivision)) {
                System.out.print(i + " ");
            }
        }

    }
}

