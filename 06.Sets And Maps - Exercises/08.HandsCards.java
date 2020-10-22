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
            Map<String, Set<String>> handsOfCards = new LinkedHashMap<>();
            String input = bfr.readLine();
            while(!"JOKER".equals(input)) {
                String[] tokens = input.split(": ");
                String personName = tokens[0];
                String[] cardTokens = tokens[1].split(", ");

                Set<String> deckCards = new LinkedHashSet<>();
                Collections.addAll(deckCards, cardTokens);


                Set<String> cards = handsOfCards.get(personName);

                if (cards == null) {
                    cards = new LinkedHashSet<>();
                    handsOfCards.put(personName, cards);
                }

                cards.addAll(deckCards);
                input = bfr.readLine();
            }

            for (Map.Entry<String, Set<String>> entry : handsOfCards.entrySet()) {
                int value = 0;
                Set<String> cards = entry.getValue();
                for (String s : cards) {
                    int power = 0;
                    int type = 0;
                    if (Character.isDigit(s.charAt(0))) {
                        if (Character.isDigit(s.charAt(1))) {
                            power = Integer.parseInt(("" + s.charAt(0) + s.charAt(1)));
                            if (s.charAt(2) == 'S') {
                                type = 4;
                            } else if (s.charAt(2) == 'H') {
                                type = 3;
                            } else if (s.charAt(2) == 'D') {
                                type = 2;
                            } else {
                                type = 1;
                            }
                            value += type * power;
                            continue;
                        }
                        power = Integer.parseInt(String.valueOf(s.charAt(0)));
                    } else {
                        if (s.charAt(0) == 'J') {
                            power = 11;
                        } else if (s.charAt(0) == 'Q') {
                            power = 12;
                        } else if (s.charAt(0) == 'K') {
                            power = 13;
                        } else {
                            power = 14;
                        }
                    }

                    if (s.charAt(1) == 'S') {
                        type = 4;
                    } else if (s.charAt(1) == 'H') {
                        type = 3;
                    } else if (s.charAt(1) == 'D') {
                        type = 2;
                    } else {
                        type = 1;
                    }

                    value += power * type;
                }

                System.out.printf("%s: %d%n", entry.getKey(), value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

