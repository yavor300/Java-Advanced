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

    private static void characterMultiplier(String firstString, String secondString) {
        int sum = 0;
        for (int i = 0; i < firstString.length() && i < secondString.length(); i++) {
            sum += firstString.charAt(i) * secondString.charAt(i);
        }

        if (firstString.length() > secondString.length()) {
            for (int i = secondString.length(); i < firstString.length(); i++) {
                sum += firstString.charAt(i);
            }
        } else {
            for (int i = firstString.length(); i < secondString.length(); i++) {
                sum += secondString.charAt(i);
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = bfr.readLine().split(", ");

            int n = Integer.parseInt(input[0]);
            String token = input[1];

            int maxNumber = 1;

            int[][] matrix = new int[n][n];
            if ("A".equals(token)) {
                while (maxNumber <= n * n) {
                    for (int row = 0; row < n; row++) {
                        for (int col = 0; col < n; col++) {
                            matrix[col][row] = maxNumber;
                            maxNumber++;
                        }
                    }
                }
            } else {
                while (maxNumber <= n * n) {
                    for (int row = 0; row < n; row++) {
                        if (row % 2 == 0) {
                            for (int col = 0; col < n; col++) {
                                matrix[col][row] = maxNumber;
                                maxNumber++;
                            }
                        } else {
                            for (int col = n - 1; col >= 0; col--) {
                                matrix[col][row] = maxNumber;
                                maxNumber++;
                            }
                        }

                    }
                }
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getFibb(int n) {
        if (n < 2) {
            return  1;
        }
        return getFibb(n-1) + getFibb(n - 2);
    }

}

