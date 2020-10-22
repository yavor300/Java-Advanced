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
            String[] dimensions = bfr.readLine().split("\\s");
            int r = Integer.parseInt(dimensions[0]);
            int c = Integer.parseInt(dimensions[1]);

            String[][] matrix = new String[r][c];

            for (int row = 0; row < r; row++) {
                String[] input = bfr.readLine().split("\\s+");
                for (int col = 0; col < c; col++) {
                    matrix[row][col] = input[col];
                }
            }

            String input = bfr.readLine();
            while (!"END".equals(input)) {
                if (input.contains("swap") && input.split("\\s").length == 5) {
                    String[] tokens = input.split("\\s+");
                    String command = tokens[0];
                    int firstRow = Integer.parseInt(tokens[1]);
                    int firstCol = Integer.parseInt(tokens[2]);
                    int secondRow = Integer.parseInt(tokens[3]);
                    int secondCol = Integer.parseInt(tokens[4]);

                    if ("swap".equals(command) && tokens.length == 5 && firstRow < r && secondRow < r && firstCol < c && secondCol < c) {
                        String firstValue = matrix[firstRow][firstCol];
                        String secondValue = matrix[secondRow][secondCol];

                        matrix[firstRow][firstCol] = secondValue;
                        matrix[secondRow][secondCol] = firstValue;

                        for (int row = 0; row < r; row++) {
                            for (int col = 0; col < c; col++) {
                                System.out.print(matrix[row][col] + " ");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Invalid input!");
                    }
                } else {
                    System.out.println("Invalid input!");
                }
                input = bfr.readLine();
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

