package com.day14.algorithms;

import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take N as a command-line argument
        if (args.length != 1) {
            System.out.println("Usage: java GuessNumber <N>");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int low = 0;
        int high = N - 1;

        System.out.println("Think of a number between 0 and " + (N - 1));

        // Call the recursive method to guess the number
        int guessedNumber = guessNumber(low, high, scanner);

        System.out.println("Your number is: " + guessedNumber);
    }

    private static int guessNumber(int low, int high, Scanner scanner) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            System.out.println("Is your number between " + low + " and " + mid + "? (true/false)");
            boolean isBetween = scanner.nextBoolean();

            if (isBetween) {
                return guessNumber(low, mid - 1, scanner);
            } else {
                return guessNumber(mid + 1, high, scanner);
            }
        } else {
            return -1; // Return -1 if the input is invalid
        }
    }
}
