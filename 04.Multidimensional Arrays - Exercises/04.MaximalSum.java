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
            String[] tokens = bfr.readLine().split("\\s+");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);

            int[][] matrix = new int[n][m];

            for (int row = 0; row < n; row++) {
                int[] numbers = parseLineOfNumbers(bfr.readLine());
                matrix[row] = numbers;
            }

            int max = Integer.MIN_VALUE;
            int rowIndex = -1;
            int colIndex = -1;

            for (int row = 1; row < n - 1; row++) {
                for (int col = 1; col < m - 1; col++) {
                    int sum = 0;
                    sum += matrix[row][col];
                    sum += matrix[row - 1][col];
                    sum += matrix[row + 1][col];
                    sum += matrix[row][col - 1];
                    sum += matrix[row][col + 1];
                    sum += matrix[row + 1][col + 1];
                    sum += matrix[row - 1][col - 1];
                    sum += matrix[row - 1][col + 1];
                    sum += matrix[row + 1][col - 1];

                    if (sum > max) {
                        max = sum;
                        rowIndex = row;
                        colIndex = col;
                    }
                }
            }

            System.out.printf("Sum = %d%n", max);
            int beginRow = rowIndex - 1;
            int beginCol = colIndex - 1;
            for (int row = beginRow; row < beginRow + 3; row++) {
                for (int col = beginCol; col < beginCol + 3; col++) {
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

