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

        Set<String> peopleNames = new LinkedHashSet<>();
        List<Person> people = new ArrayList<>();

        String input = bfr.readLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String personName = tokens[0];

            if (peopleNames.add(personName)) {
                Person person = new Person(personName);
                switch (tokens[1]) {
                    case "company":
                        String companyName = tokens[2];
                        String companyDepartment = tokens[3];
                        double companySalary = Double.parseDouble(tokens[4]);

                        Company company = new Company(companyName, companyDepartment, companySalary);

                        person.setCompany(company);
                        break;

                    case "pokemon":
                        String pokemonName = tokens[2];
                        String pokemonType = tokens[3];

                        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                        person.getPokemon().add(pokemon);
                        break;

                    case "parents":
                        String parentName = tokens[2];
                        String parentBirthday = tokens[3];

                        Parent parent = new Parent(parentName, parentBirthday);

                        person.getParents().add(parent);
                        break;

                    case "children":
                        String childName = tokens[2];
                        String childBirthday = tokens[3];

                        Child child = new Child(childName, childBirthday);

                        person.getChildren().add(child);
                        break;

                    case "car":
                        String carModel = tokens[2];
                        int carSpeed = Integer.parseInt(tokens[3]);

                        Car car = new Car(carModel, carSpeed);

                        person.setCar(car);
                        break;
                }
                people.add(person);
            } else {
                Person person;
                for (Person person1 : people) {
                    if (person1.getName().equals(personName)) {
                        person = person1;
                        switch (tokens[1]) {
                            case "company":
                                String companyName = tokens[2];
                                String companyDepartment = tokens[3];
                                double companySalary = Double.parseDouble(tokens[4]);

                                Company company = new Company(companyName, companyDepartment, companySalary);

                                person.setCompany(company);
                                break;

                            case "pokemon":
                                String pokemonName = tokens[2];
                                String pokemonType = tokens[3];

                                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                                person.getPokemon().add(pokemon);
                                break;

                            case "parents":
                                String parentName = tokens[2];
                                String parentBirthday = tokens[3];

                                Parent parent = new Parent(parentName, parentBirthday);

                                person.getParents().add(parent);
                                break;

                            case "children":
                                String childName = tokens[2];
                                String childBirthday = tokens[3];

                                Child child = new Child(childName, childBirthday);

                                person.getChildren().add(child);
                                break;

                            case "car":
                                String carModel = tokens[2];
                                int carSpeed = Integer.parseInt(tokens[3]);

                                Car car = new Car(carModel, carSpeed);

                                person.setCar(car);
                                break;
                        }
                        break;
                    }
                }

            }

            input = bfr.readLine();
        }

        String name = bfr.readLine();
        for (Person person : people) {
            if (person.getName().equals(name)) {
                System.out.print(person.toString());
                break;
            }
        }
    }
}

