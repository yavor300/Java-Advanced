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

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String[] robotsData = bfr.readLine().split(";");
            String[] robots = new String[robotsData.length];
            int[] processTime = new int[robotsData.length];
            int[] workTime = new int[robotsData.length];

            for (int i = 0; i < robotsData.length; i++) {
                String[] data = robotsData[i].split("-");
                String name = data[0];
                int time = Integer.parseInt(data[1]);
                robots[i] = name;
                processTime[i] = time;
            }


            String startingTime = bfr.readLine();

            ArrayDeque<String> queue = new ArrayDeque<>();
            String productInput = bfr.readLine();
            while (!"End".equals(productInput)) {
                queue.offer(productInput);
                productInput = bfr.readLine();
            }

            String[] timeData = startingTime.split(":");
            int hours = Integer.parseInt(timeData[0]);
            int minutes = Integer.parseInt(timeData[1]);
            int seconds = Integer.parseInt(timeData[2]);

            int beginSeconds = hours * 3600 + minutes * 60 + seconds;

            while (!queue.isEmpty()) {
                beginSeconds++;
                String product = queue.poll();
                boolean isAssigned = false;
                for (int i = 0; i < robots.length; i++) {
                    if (workTime[i] == 0 && !isAssigned) {
                        workTime[i] = processTime[i];
                        isAssigned = true;
                        printRobotData(robots[i], product, beginSeconds);
                    }
                    if (workTime[i] > 0) {
                        workTime[i]--;
                    }
                }
                if (!isAssigned) {
                    queue.offer(product);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static  void printRobotData(String robot, String product, int beginSeconds) {
        long s = beginSeconds % 60;
        long m = (beginSeconds / 60) % 60;
        long h = (beginSeconds / (60 * 60)) % 24;
        System.out.println(robot + " - " + product + String.format(" [%02d:%02d:%02d]", h, m ,s));
    }
}

