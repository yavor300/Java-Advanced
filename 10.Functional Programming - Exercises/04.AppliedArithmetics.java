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

        if (numbers == null) {
            return;
        }
        Map<String, Function<Integer[], Integer[]>> functions = new LinkedHashMap<>();

        Function<Integer[], Integer[]> add = arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + 1;
            }
            return arr;
        };

        Function<Integer[], Integer[]> multiply = arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * 2;
            }
            return arr;
        };

        Function<Integer[], Integer[]> subtract = arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - 1;
            }
            return arr;
        };

        Function<Integer[], Integer[]> print = arr -> {
            Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
            System.out.println();
            return arr;
        };

        functions.put("add", add);
        functions.put("multiply", multiply);
        functions.put("subtract", subtract);
        functions.put("print", print);

        boolean isPrinted = false;

        String input = bfr.readLine();
        while (!"end".equals(input)) {
            if (input.equals("print")) {
                isPrinted = true;
            }
            if (input.equals("add") || input.equals("multiply") || input.equals("subtract") || input.equals("print")) {
                numbers = functions.get(input).apply(numbers);
            }

            input = bfr.readLine();
        }

        if (!isPrinted) {
            functions.get("print").apply(numbers);
        }


    }
}

