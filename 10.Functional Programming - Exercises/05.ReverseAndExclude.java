package com.company;


import java.io.*;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;
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

    private static void removeIndex(int[] numbers, int[] newNumbers, int indexToRemove) {
        for (int i = 0; i < newNumbers.length; i++) {
            if (i >= indexToRemove) {
                newNumbers[i] = numbers[i + 1];
            } else {
                newNumbers[i] = numbers[i];
            }
        }
        numbers = newNumbers;
    }

    private static List<Integer> getIntegersInList(String line) {
        List<Integer> numbers = new ArrayList<>();
        String[] strings = line.split(" ");
        for (String numberString : strings) {
            numbers.add(Integer.parseInt(numberString));
        }
        return numbers;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = parseLineOfNumbers(bfr.readLine());

        int n = Integer.parseInt(bfr.readLine());

        BiFunction<Integer[], Integer, String> printCollectionBackwards = (arr, divisionNum) -> {
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] % divisionNum != 0) {
                    sb.append(arr[i]).append(" ");
                }
            }
            return sb.toString();
        };

        System.out.println(printCollectionBackwards.apply(numbers, n));
    }
}

