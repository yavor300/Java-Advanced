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
            Map<String, String> phonebook = new LinkedHashMap<>();
            String addData = bfr.readLine();
            while (!"search".equals(addData)) {
                String[] tokens = addData.split("-");
                phonebook.put(tokens[0], tokens[1]);
                addData = bfr.readLine();
            }

            String searchData = bfr.readLine();
            while (!"stop".equals(searchData)) {
                String number = phonebook.get(searchData);
                if (number == null) {
                    System.out.printf("Contact %s does not exist.%n", searchData);
                } else {
                    System.out.printf("%s -> %s%n", searchData, number);
                }
                searchData = bfr.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

