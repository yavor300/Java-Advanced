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
        String[] numberString = line.split(", ");
        Integer[] numbers = new Integer[numberString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberString[i]);
        }
        return numbers;
    }



    //IS MATRIX IN RANGE
    private static boolean isInRange(int playerRow, int playerCol, char[][] matrix) {
        return playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[playerRow].length;
    }

    //TRAP CHECKER
    private static boolean isOnTrap(int playerRow, int playerCol, char[][] matrix) {
        return matrix[playerRow][playerCol] == 'T';
    }

    //BONUS CHECKER
    private static boolean isOnBonus(int playerRow, int playerCol, char[][] matrix) {
        return matrix[playerRow][playerCol] == 'B';
    }

    //FINAL CHECKER
    private static boolean isOnFinish(int playerRow, int playerCol, int finalRow, int finalCol) {
        return (playerRow == finalRow) && (playerCol == finalCol);
    }

    // PRINT MATRIX
    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Integer[] bombEffects = parseLineOfNumbers(bfr.readLine());
        Integer[] bombCasing = parseLineOfNumbers(bfr.readLine());

        ArrayDeque<Integer> queueEffect = new ArrayDeque<>();
        for (Integer bombEffect : bombEffects) {
            queueEffect.offer(bombEffect);
        }

        ArrayDeque<Integer> stackCasing = new ArrayDeque<>();
        for (Integer casing : bombCasing) {
            stackCasing.push(casing);
        }

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        while (!queueEffect.isEmpty() && !stackCasing.isEmpty()) {
            if (queueEffect.peek() + stackCasing.peek() == 40) {
                bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                queueEffect.poll();
                stackCasing.pop();
                if (bombs.get("Datura Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3) {
                    break;
                }
            } else if (queueEffect.peek() + stackCasing.peek() == 60) {
                bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                queueEffect.poll();
                stackCasing.pop();
                if (bombs.get("Datura Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3) {
                    break;
                }
            } else if (queueEffect.peek() + stackCasing.peek() == 120) {
                bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                queueEffect.poll();
                stackCasing.pop();
                if (bombs.get("Datura Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3) {
                    break;
                }
            } else {
                stackCasing.push(stackCasing.pop() - 5);
                //TODO 0...
            }
        }

        if (bombs.get("Datura Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (queueEffect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            StringBuilder sb = new StringBuilder();
            while(!queueEffect.isEmpty()) {
                sb.append(queueEffect.poll()).append(", ");
            }
            sb.deleteCharAt(sb.toString().length() - 2);
            String result = sb.toString().trim();
            System.out.print(result);
            System.out.println();
        }

        if (stackCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            StringBuilder sb = new StringBuilder();
            while(!stackCasing.isEmpty()) {
                sb.append(stackCasing.pop()).append(", ");
            }
            sb.deleteCharAt(sb.toString().length() - 2);
            String result = sb.toString().trim();
            System.out.print(result);
            System.out.println();
        }

        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }


    }
}

