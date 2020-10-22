package com.company;


import java.io.*;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Main {
    

    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bfr.readLine());
        String[] names = bfr.readLine().split("\\s+");

        BiPredicate<String, Integer> checkNameLength = (name, length) -> name.length() <= length;

        for (String name : names) {
            if (checkNameLength.test(name, n)) {
                System.out.println(name);
            }
        }

    }
}

