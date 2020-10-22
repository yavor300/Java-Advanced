package com.company;


import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(bfr.readLine().split("\\s+"))
                .forEach(s -> System.out.println("Sir " + s));s
    }
}

