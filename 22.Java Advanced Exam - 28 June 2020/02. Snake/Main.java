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
    
    //IS MATRIX IN RANGE
    private static boolean isInRange(int playerRow, int playerCol, char[][] matrix) {
        return playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[playerRow].length;
    }

    //TRAP CHECKER
    private static boolean isOnTrap(int playerRow, int playerCol, char[][] matrix) {
        return matrix[playerRow][playerCol] == 'B';
    }

    //BONUS CHECKER
    private static boolean isOnBonus(int playerRow, int playerCol, char[][] matrix) {
        return matrix[playerRow][playerCol] == '*';
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

        int n = Integer.parseInt(bfr.readLine());
        char[][] matrix = new char[n][n];

        int snakeRow = 0;
        int snakeCol = 0;

        int countForBurrows = 0;

        int burrowOneRow = -1;
        int burrowOneCol = -1;

        int burrowTwoRow = -1;
        int burrowTwoCol = -1;

        int foodQuantity = 0;

        for (int row = 0; row < matrix.length; row++) {
            char[] tokens = bfr.readLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                if (tokens[col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                }
                if (tokens[col] == 'B') {
                    if (countForBurrows == 0) {
                        burrowOneRow = row;
                        burrowOneCol = col;
                        countForBurrows++;
                    } else {
                        burrowTwoRow = row;
                        burrowTwoCol = col;
                    }
                }
                matrix[row][col] = tokens[col];
            }
        }

        while (true) {
            String movement = bfr.readLine();
            matrix[snakeRow][snakeCol] = '.';
            switch (movement) {
                case "up":
                    if (!isInRange(snakeRow - 1, snakeCol, matrix)) {
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", foodQuantity);
                        printMatrix(matrix);
                        return;
                    }

                    if (isOnBonus(snakeRow - 1, snakeCol, matrix)) {
                        foodQuantity++;
                        if (foodQuantity >= 10) {
                            System.out.println("You won! You fed the snake.");
                            System.out.printf("Food eaten: %d%n", foodQuantity);
                            snakeRow--;
                            matrix[snakeRow][snakeCol] = 'S';
                            printMatrix(matrix);
                            return;
                        }
                    }

                    if (isOnTrap(snakeRow - 1, snakeCol, matrix)) {
                        if (snakeRow - 1 == burrowOneRow && snakeCol == burrowOneCol) {
                            matrix[burrowOneRow][burrowOneCol] = '.';
                            matrix[burrowTwoRow][burrowTwoCol] = 'S';
                            snakeRow = burrowTwoRow;
                            snakeCol = burrowTwoCol;
                            continue;
                        } else {
                            matrix[burrowOneRow][burrowOneCol] = 'S';
                            matrix[burrowTwoRow][burrowTwoCol] = '.';
                            snakeRow = burrowOneRow;
                            snakeCol = burrowOneCol;
                            continue;
                        }
                    }
                    snakeRow--;
                    matrix[snakeRow][snakeCol] = 'S';
                    break;

                case "down":
                    if (!isInRange(snakeRow + 1, snakeCol, matrix)) {
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", foodQuantity);
                        printMatrix(matrix);
                        return;
                    }

                    if (isOnBonus(snakeRow + 1, snakeCol, matrix)) {
                        foodQuantity++;
                        if (foodQuantity >= 10) {
                            System.out.println("You won! You fed the snake.");
                            System.out.printf("Food eaten: %d%n", foodQuantity);
                            snakeRow++;
                            matrix[snakeRow][snakeCol] = 'S';
                            printMatrix(matrix);
                            return;
                        }
                    }

                    if (isOnTrap(snakeRow + 1, snakeCol, matrix)) {
                        if (snakeRow + 1 == burrowOneRow && snakeCol == burrowOneCol) {
                            matrix[burrowOneRow][burrowOneCol] = '.';
                            matrix[burrowTwoRow][burrowTwoCol] = 'S';
                            snakeRow = burrowTwoRow;
                            snakeCol = burrowTwoCol;
                            continue;
                        } else {
                            matrix[burrowOneRow][burrowOneCol] = 'S';
                            matrix[burrowTwoRow][burrowTwoCol] = '.';
                            snakeRow = burrowOneRow;
                            snakeCol = burrowOneCol;
                            continue;
                        }
                    }
                    snakeRow++;
                    matrix[snakeRow][snakeCol] = 'S';
                    break;

                case "left":
                    if (!isInRange(snakeRow, snakeCol - 1, matrix)) {
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", foodQuantity);
                        printMatrix(matrix);
                        return;
                    }

                    if (isOnBonus(snakeRow, snakeCol - 1, matrix)) {
                        foodQuantity++;
                        if (foodQuantity >= 10) {
                            System.out.println("You won! You fed the snake.");
                            System.out.printf("Food eaten: %d%n", foodQuantity);
                            snakeCol--;
                            matrix[snakeRow][snakeCol] = 'S';
                            printMatrix(matrix);
                            return;
                        }
                    }

                    if (isOnTrap(snakeRow, snakeCol - 1, matrix)) {
                        if (snakeRow == burrowOneRow && snakeCol - 1 == burrowOneCol) {
                            matrix[burrowOneRow][burrowOneCol] = '.';
                            matrix[burrowTwoRow][burrowTwoCol] = 'S';
                            snakeRow = burrowTwoRow;
                            snakeCol = burrowTwoCol;
                            continue;
                        } else {
                            matrix[burrowOneRow][burrowOneCol] = 'S';
                            matrix[burrowTwoRow][burrowTwoCol] = '.';
                            snakeRow = burrowOneRow;
                            snakeCol = burrowOneCol;
                            continue;
                        }
                    }
                    snakeCol--;
                    matrix[snakeRow][snakeCol] = 'S';
                    break;

                case "right":
                    if (!isInRange(snakeRow, snakeCol + 1, matrix)) {
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", foodQuantity);
                        printMatrix(matrix);
                        return;
                    }

                    if (isOnBonus(snakeRow, snakeCol + 1, matrix)) {
                        foodQuantity++;
                        if (foodQuantity >= 10) {
                            System.out.println("You won! You fed the snake.");
                            System.out.printf("Food eaten: %d%n", foodQuantity);
                            snakeCol++;
                            matrix[snakeRow][snakeCol] = 'S';
                            printMatrix(matrix);
                            return;
                        }
                    }

                    if (isOnTrap(snakeRow, snakeCol + 1, matrix)) {
                        if (snakeRow == burrowOneRow && snakeCol + 1 == burrowOneCol) {
                            matrix[burrowOneRow][burrowOneCol] = '.';
                            matrix[burrowTwoRow][burrowTwoCol] = 'S';
                            snakeRow = burrowTwoRow;
                            snakeCol = burrowTwoCol;
                            continue;
                        } else {
                            matrix[burrowOneRow][burrowOneCol] = 'S';
                            matrix[burrowTwoRow][burrowTwoCol] = '.';
                            snakeRow = burrowOneRow;
                            snakeCol = burrowOneCol;
                            continue;
                        }
                    }
                    snakeCol++;
                    matrix[snakeRow][snakeCol] = 'S';
                    break;
            }
        }
    }
}

