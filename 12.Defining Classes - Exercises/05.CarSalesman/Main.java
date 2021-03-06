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

        int n = Integer.parseInt(bfr.readLine());
        Engine[] engines = new Engine[n];
        for (int i = 0; i < n; i++) {
            String[] tokens = bfr.readLine().split("\\s+");

            String engineModel = tokens[0];
            int enginePower = Integer.parseInt(tokens[1]);

            Engine engine = new Engine(engineModel, enginePower);

            if (tokens.length == 3 && Character.isDigit(tokens[2].charAt(0))) {
                int engineDisplacement = Integer.parseInt(tokens[2]);
                engine.setDisplacement(engineDisplacement);
            } else if (tokens.length == 3 && Character.isLetter(tokens[2].charAt(0))) {
                String efficiency = tokens[2];
                engine.setEfficiency(efficiency);
            } else if (tokens.length == 4) {
                int engineDisplacement = Integer.parseInt(tokens[2]);
                engine.setDisplacement(engineDisplacement);

                String efficiency = tokens[3];
                engine.setEfficiency(efficiency);
            }

            if (engine.getEfficiency() == null){
                engine.setEfficiency("n/a");
            }

            engines[i] = engine;
        }

        int m = Integer.parseInt(bfr.readLine());
        Car[] cars = new Car[m];
        for (int i = 0; i < m; i++) {
            String[] tokens = bfr.readLine().split("\\s+");
            String carModel = tokens[0];

            Engine carEngine = null;
            for (Engine engine : engines) {
                if (engine.getModel().equals(tokens[1])) {
                    carEngine = engine;
                    break;
                }
            }

            Car car = new Car(carModel, carEngine);

            if (tokens.length == 3 && Character.isDigit(tokens[2].charAt(0))) {
                int carWeight = Integer.parseInt(tokens[2]);
                car.setWeight(carWeight);
            } else if (tokens.length == 3 && Character.isLetter(tokens[2].charAt(0))) {
                String carColor = tokens[2];
                car.setColor(carColor);
            } else if (tokens.length == 4) {
                int carWeight = Integer.parseInt(tokens[2]);
                car.setWeight(carWeight);

                String carColor = tokens[3];
                car.setColor(carColor);
            }

            if (car.getColor() == null) {
                car.setColor("n/a");
            }

            cars[i] = car;
        }

        for (Car car : cars) {
            System.out.print(car.toString());
        }

    }
}

