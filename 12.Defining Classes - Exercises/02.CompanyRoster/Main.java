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
    //FIND DUPLICATED OBJECT IN A LIST
//    static Product findProduct(String name, List<Product> products) {
//        for (Product product : products) {
//            if (product.getName().equals(name)) {
//                return product;
//            }
//        }
//        return null;
//    }

    //REPEAT A WORD DEPENDING OT IT'S LETTERS COUNT
    private  static String repeat(String word, int length) {
        String[] repeated = new String[length];
        for (int i = 0; i < repeated.length; i++) {
            repeated[i] = word;
        }
        return String.join("", repeated);
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

    //FILLING THE MATRIX
    /*for (int row = 0; row < n; row++) {
        String[] input = scanner.nextLine().split("\\s+");
        for (int col = 0; col < input.length; col++) {
            matrix[row][col] = Integer.parseInt(input[col]);
        }
    }*/

    //BOTH DIAGONALS
    /*int row = 0;
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
    }*/

    /*ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    int value = 1;
        for (int row = 0; row < numbers[0]; row++) {
        ArrayList<Integer> rowList = new ArrayList<>();
        for (int col = 0; col < numbers[1]; col++) {
            rowList.add(value);
            value++;
        }
        matrix.add(rowList);
    }*/

    /*
    private static double calcFact(double number) {
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
     */

    //IS MATRIX IN RANGE
    /*
    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

     */

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Employee>> company = new LinkedHashMap<>();


        int n = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = bfr.readLine().split("\\s+");
            String name = tokens[0];
            Double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = new Employee(name, salary, position, department);

            if (tokens.length == 5 && tokens[4].contains("@")) {
                employee.setEmail(tokens[4]);
            } else if ((tokens.length == 5)) {
                employee.setAge(Integer.parseInt(tokens[4]));
            } else if (tokens.length == 6) {
                employee.setEmail(tokens[4]);
                employee.setAge(Integer.parseInt(tokens[5]));
            }

            List<Employee> employees = company.get(department);
            if (employees == null) {
                employees = new ArrayList<>();
                company.put(department, employees);
            }

            employees.add(employee);
        }

        double max = Double.MIN_VALUE;
        String departmentWithHighestSalary = "";

        for (Map.Entry<String, List<Employee>> entry : company.entrySet()) {
            double departmentAverageSalary = entry.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();

            if (departmentAverageSalary > max) {
                max = departmentAverageSalary;
                departmentWithHighestSalary = entry.getKey();
            }
        }

        System.out.println("Highest Average Salary: " + departmentWithHighestSalary);
        for (Map.Entry<String, List<Employee>> entry : company.entrySet()) {
            if (entry.getKey().equals(departmentWithHighestSalary)) {
                List<Employee> value = entry.getValue();
                value.stream()
                        .sorted((f, s) -> s.getSalary().compareTo(f.getSalary()))
                        .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
            }
        }
    }
}

