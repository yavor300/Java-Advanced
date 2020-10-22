package com.company;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static int[] parseLineOfNumbers(String line) {
        String[] numberString = line.split(" ");
        int[] numbers = new int[numberString.length];

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
    
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, Integer> symbols = new LinkedHashMap<>();
            String input = bfr.readLine();
            if (input.isEmpty()) {
                return;
            }
            String[] characters = input.split("");
            for (String character : characters) {
                if (symbols.containsKey(character)) {
                    symbols.put(character, symbols.get(character) + 1);
                } else {
                    symbols.put(character, 1);
                }
            }

            symbols.entrySet().stream().sorted((f, s) -> f.getKey().compareTo(s.getKey())).forEach(e -> System.out.printf("%s: %d time/s%n", e.getKey(), e.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

