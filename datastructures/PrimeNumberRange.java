package com.day14.datastructures;

public class PrimeNumberRange {

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] primeArray = new int[10][];
        int startRange = 0;
        int endRange = 100;

        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (int j = startRange; j < endRange; j++) {
                if (isPrime(j)) {
                    count++;
                }
            }

            primeArray[i] = new int[count];
            int index = 0;
            for (int j = startRange; j < endRange; j++) {
                if (isPrime(j)) {
                    primeArray[i][index++] = j;
                }
            }

            startRange += 100;
            endRange += 100;
        }

        // Displaying the prime numbers in the 2D array
        for (int i = 0; i < 10; i++) {
            System.out.print("Range " + (i * 100) + "-" + ((i + 1) * 100 - 1) + ": ");
            for (int prime : primeArray[i]) {
                System.out.print(prime + " ");
            }
            System.out.println();
        }
    }
}
