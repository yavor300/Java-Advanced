package com.company;


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static Integer[] parseLineOfNumbers(String line) {
        String[] numberString = line.split(" ");
        Integer[] numbers = new Integer[numberString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberString[i]);
        }
        return numbers;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Integer[] firstLootBox = parseLineOfNumbers(bfr.readLine());
        Integer[] secondLootBox = parseLineOfNumbers(bfr.readLine());

        ArrayDeque<Integer> queueFirstLootBox = new ArrayDeque<>();
        for (Integer lootBox : firstLootBox) {
            queueFirstLootBox.offer(lootBox);
        }

        ArrayDeque<Integer> stackSecondLootBox = new ArrayDeque<>();
        for (Integer lootBox : secondLootBox) {
            stackSecondLootBox.push(lootBox);
        }

        List<Integer> claimedItems = new ArrayList<>();

        while (!queueFirstLootBox.isEmpty() && !stackSecondLootBox.isEmpty()) {
            int result = queueFirstLootBox.peek() + stackSecondLootBox.peek();
            if (result % 2 == 0) {
                claimedItems.add(result);
                queueFirstLootBox.poll();
                stackSecondLootBox.pop();
            } else {
                queueFirstLootBox.offer(stackSecondLootBox.pop());
            }
        }

        if (queueFirstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        int collectedItemsSum = claimedItems.stream().mapToInt(Integer::intValue).sum();
        if (collectedItemsSum >= 100) {
            System.out.printf("Your loot was epic! Value: %d", collectedItemsSum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", collectedItemsSum);
        }
    }
}

