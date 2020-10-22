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
            int n = Integer.parseInt(bfr.readLine());
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                String[] input = bfr.readLine().split("\\s+");
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(input[col]);
                }
            }

            int row = 0;
            int col = 0;
            int primarySum = 0;
            while (row < n && col < n) {
                primarySum  += matrix[row][col];
                row++;
                col++;
            }

            row--;
            col = 0;
            int secondarySum = 0;
            while (row >= 0 && col < n) {
                secondarySum += matrix[row][col];
                row--;
                col++;
            }

            System.out.println(Math.abs(primarySum - secondarySum));

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

