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

        int matrixSize = Integer.parseInt(bfr.readLine());
        int numberOfCommands = Integer.parseInt(bfr.readLine());
        char[][] matrix = new char[matrixSize][matrixSize];

        int playerRow = 0;
        int playerCol = 0;

        int finishRow = 0;
        int finishCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            char[] elements = bfr.readLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                if (elements[col] == 'f') {
                    playerRow = row;
                    playerCol = col;
                } else if (elements[col] == 'F') {
                    finishRow = row;
                    finishCol = col;
                }
                matrix[row][col] = elements[col];
            }
        }

        for (int i = 0; i < numberOfCommands; i++) {
            String movement = bfr.readLine();
            matrix[playerRow][playerCol] = '-';
            switch (movement) {
                case "up":
                    // UPDATE POSITION
                    if (!isInRange(playerRow - 1, playerCol, matrix)) {
                        playerRow = matrixSize - 1;
                    } else {
                        playerRow--;
                    }

                    // CHECK FOR TRAP
                    if (isOnTrap(playerRow, playerCol, matrix)) {
                        if (!isInRange(playerRow + 1, playerCol, matrix)) {
                            playerRow = 0;
                        } else {
                            playerRow++;
                        }
                    }

                    // CHECK FOR BONUS
                    if (isOnBonus(playerRow, playerCol, matrix)) {
                        if (!isInRange(playerRow - 1, playerCol, matrix)) {
                            playerRow = matrixSize - 1;
                        } else {
                            playerRow--;
                        }
                    }

                    matrix[playerRow][playerCol] = 'f';

                    // CHECK FOR FINISH
                    if (isOnFinish(playerRow, playerCol, finishRow, finishCol)) {
                        System.out.println("Player won!");
                        printMatrix(matrix);
                        return;
                    }
                    break;

                case "down":
                    // UPDATE POSITION
                    if (!isInRange(playerRow + 1, playerCol, matrix)) {
                        playerRow = 0;
                    } else {
                        playerRow++;
                    }

                    // CHECK FOR TRAP
                    if (isOnTrap(playerRow, playerCol, matrix)) {
                        if (!isInRange(playerRow - 1, playerCol, matrix)) {
                            playerRow = matrixSize - 1;
                        } else {
                            playerRow--;
                        }
                    }

                    // CHECK FOR BONUS
                    if (isOnBonus(playerRow, playerCol, matrix)) {
                        if (!isInRange(playerRow + 1, playerCol, matrix)) {
                            playerRow = 0;
                        } else {
                            playerRow++;
                        }
                    }

                    matrix[playerRow][playerCol] = 'f';

                    // CHECK FOR FINISH
                    if (isOnFinish(playerRow, playerCol, finishRow, finishCol)) {
                        System.out.println("Player won!");
                        printMatrix(matrix);
                        return;
                    }
                    break;

                case "left":
                    // UPDATE POSITION
                    if (!isInRange(playerRow, playerCol - 1, matrix)) {
                        playerCol = matrix[playerRow].length - 1;
                    } else {
                        playerCol--;
                    }

                    // CHECK FOR TRAP
                    if (isOnTrap(playerRow, playerCol, matrix)) {
                        if (!isInRange(playerRow, playerCol + 1, matrix)) {
                            playerCol = 0;
                        } else {
                            playerCol++;
                        }
                    }

                    // CHECK FOR BONUS
                    if (isOnBonus(playerRow, playerCol, matrix)) {
                        if (!isInRange(playerRow, playerCol - 1, matrix)) {
                            playerCol = matrix[playerRow].length - 1;
                        } else {
                            playerCol--;
                        }
                    }

                    matrix[playerRow][playerCol] = 'f';

                    // CHECK FOR FINISH
                    if (isOnFinish(playerRow, playerCol, finishRow, finishCol)) {
                        System.out.println("Player won!");
                        printMatrix(matrix);
                        return;
                    }
                    break;

                case "right":
                    // UPDATE POSITION
                    if (!isInRange(playerRow, playerCol + 1, matrix)) {
                        playerCol = 0;
                    } else {
                        playerCol++;
                    }

                    // CHECK FOR TRAP
                    if (isOnTrap(playerRow, playerCol, matrix)) {
                        if (!isInRange(playerRow, playerCol - 1, matrix)) {
                            playerCol = matrix[playerRow].length - 1;
                        } else {
                            playerCol--;
                        }
                    }

                    // CHECK FOR BONUS
                    if (isOnBonus(playerRow, playerCol, matrix)) {
                        if (!isInRange(playerRow, playerCol + 1, matrix)) {
                            playerCol = 0;
                        } else {
                            playerCol++;
                        }
                    }

                    matrix[playerRow][playerCol] = 'f';

                    // CHECK FOR FINISH
                    if (isOnFinish(playerRow, playerCol, finishRow, finishCol)) {
                        System.out.println("Player won!");
                        printMatrix(matrix);
                        return;
                    }
                    break;
            }
        }

        System.out.println("Player lost!");
        printMatrix(matrix);


    }
}

