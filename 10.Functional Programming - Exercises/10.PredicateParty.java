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

    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String[] comingPeople = bfr.readLine().split("\\s+");
        List<String> invitedPeople = new ArrayList<>(Arrays.asList(comingPeople));

        Map<String, BiPredicate<String, String>> functions = new LinkedHashMap<>();

        BiPredicate<String, String> startWithAGivenString = (str, prefix) -> str.startsWith(prefix);
        BiPredicate<String, String> endWithAGivenString = (str, suffix) -> str.endsWith(suffix);
        BiPredicate<String, String> hasLength = (str, length) -> str.length() == Integer.parseInt(length);

        functions.put("StartsWith", startWithAGivenString);
        functions.put("EndsWith", endWithAGivenString);
        functions.put("Length", hasLength);

        String input = bfr.readLine();
        while (!"Party!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[1];
            String criteria = tokens[2];

            switch (tokens[0]) {
                case "Remove":
                    for (int i = 0; i < invitedPeople.size(); i++) {
                        if (functions.get(command).test(invitedPeople.get(i), criteria)) {
                            invitedPeople.remove(invitedPeople.get(i));
                            i--;
                        }
                    }
                    break;

                case "Double":
                    for (int i = 0; i < invitedPeople.size(); i++) {
                        if (functions.get(command).test(invitedPeople.get(i), criteria)) {
                            invitedPeople.add(invitedPeople.get(i));
                            i++;
                        }
                    }
                    break;
            }
            input = bfr.readLine();
        }

        if (invitedPeople.isEmpty()) {
            System.out.println("Nobody is going to the party!");
            return;
        }

        Collections.sort(invitedPeople);
        String join = String.join(", ", invitedPeople);
        System.out.println(join + " are going to the party!");

    }
}

