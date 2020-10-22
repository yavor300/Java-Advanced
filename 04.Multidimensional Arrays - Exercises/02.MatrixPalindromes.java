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
            String[] input = bfr.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            StringBuilder sb = new StringBuilder();
            String[][] matrix = new String[r][c];

            for (int row = 0; row < r; row++) {
                for (int col = 0; col < c; col++) {
                    matrix[row][col] = sb.append((char) (97 + row)).append((char) (97 + col + row)).append((char) (97 + row)).toString();
                    sb = new StringBuilder();
                }
            }

            for (int row = 0; row < r; row++) {
                for (int col = 0; col < c; col++) {
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

