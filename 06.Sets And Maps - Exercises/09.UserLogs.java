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
            Map<String, Map<String, Integer>> logs = new TreeMap<>();
            String input = bfr.readLine();
            while (!"end".equals(input)) {
                String[] tokens = input.split("=");
                String IPAddress = tokens[1].split("\\s")[0];
                String username = tokens[tokens.length - 1];

                Map<String, Integer> ipAddresses = logs.get(username);
                if (ipAddresses == null) {
                    ipAddresses = new LinkedHashMap<>();
                    logs.put(username, ipAddresses);
                }

                if (ipAddresses.containsKey(IPAddress)) {
                    ipAddresses.put(IPAddress, ipAddresses.get(IPAddress) + 1);
                } else {
                    ipAddresses.put(IPAddress, 1);
                }

                input = bfr.readLine();
            }

            for (Map.Entry<String, Map<String, Integer>> entry : logs.entrySet()) {
                String username = entry.getKey();
                Map<String, Integer> value = entry.getValue();

                System.out.println(username + ":");
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Integer> integerEntry : value.entrySet()) {
                    sb.append(String.format("%s => %d, ", integerEntry.getKey(), integerEntry.getValue()));
                }
                sb.deleteCharAt(sb.toString().length() - 1);
                sb.deleteCharAt(sb.toString().length() - 1);
                sb.append(".");
                System.out.println(sb.toString());

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

