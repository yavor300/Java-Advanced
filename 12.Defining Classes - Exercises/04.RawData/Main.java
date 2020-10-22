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
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = bfr.readLine().split("\\s+");
            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            double firstTirePressure = Double.parseDouble(tokens[5]);
            int firstTireAge = Integer.parseInt(tokens[6]);

            double secondTirePressure = Double.parseDouble(tokens[7]);
            int secondTireAge = Integer.parseInt(tokens[8]);

            double thirdTirePressure = Double.parseDouble(tokens[9]);
            int thirdTireAge = Integer.parseInt(tokens[10]);

            double fourthTirePressure = Double.parseDouble(tokens[11]);
            int fourthTireAge = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire firstTire = new Tire(firstTirePressure, firstTireAge);
            Tire secondTire = new Tire(secondTirePressure, secondTireAge);
            Tire thirdTire = new Tire(thirdTirePressure, thirdTireAge);
            Tire fourthTire = new Tire(fourthTirePressure, fourthTireAge);

            Car car = new Car(model, engine, cargo, new Tire[]{firstTire, secondTire, thirdTire, fourthTire});

            cars[i] = car;
        }

        String command = bfr.readLine();
        if ("fragile".equals(command)) {
            for (Car car : cars) {
                if (car.getCargo().getType().equals(command)) {
                    boolean isPressureValid = false;
                    Tire[] tires = car.getTires();
                    for (Tire tire : tires) {
                        if (tire.getPressure() < 1) {
                            isPressureValid = true;
                            break;
                        }
                    }

                    if (isPressureValid) {
                        System.out.println(car.getModel());
                    }
                }
            }

        } else {
            for (Car car : cars) {
                if (car.getCargo().getType().equals(command) && car.getEngine().getPower() > 250) {
                    System.out.println(car.getModel());
                }
            }

        }
    }
}

