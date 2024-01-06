package com.day14.datastructures;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramPrimeNumbers {

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

    public static boolean areAnagrams(int num1, int num2) {
        char[] str1 = Integer.toString(num1).toCharArray();
        char[] str2 = Integer.toString(num2).toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }

    public static void main(String[] args) {
        List<Integer> primeNumbers = new ArrayList<>();

        // Finding prime numbers in the range of 0 to 1000
        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        int[][] anagramArray = new int[primeNumbers.size()][];
        int[][] nonAnagramArray = new int[primeNumbers.size()][];

        int anagramCount = 0;
        int nonAnagramCount = 0;

        // Identifying anagrams and storing in respective arrays
        for (int i = 0; i < primeNumbers.size(); i++) {
            for (int j = i + 1; j < primeNumbers.size(); j++) {
                if (areAnagrams(primeNumbers.get(i), primeNumbers.get(j))) {
                    if (anagramArray[anagramCount] == null) {
                        anagramArray[anagramCount] = new int[]{primeNumbers.get(i)};
                        anagramCount++;
                    }
                    anagramArray[anagramCount - 1] = Arrays.copyOf(anagramArray[anagramCount - 1], anagramArray[anagramCount - 1].length + 1);
                    anagramArray[anagramCount - 1][anagramArray[anagramCount - 1].length - 1] = primeNumbers.get(j);
                }
            }
        }

        // Displaying the 2D array of anagram prime numbers
        System.out.println("Anagram Prime Numbers:");
        for (int i = 0; i < anagramCount; i++) {
            System.out.print("Set " + (i + 1) + ": ");
            for (int anagram : anagramArray[i]) {
                System.out.print(anagram + " ");
            }
            System.out.println();
        }

        // Displaying the 2D array of non-anagram prime numbers
        System.out.println("\nNon-Anagram Prime Numbers:");
        for (int i = 0; i < nonAnagramCount; i++) {
            System.out.print("Set " + (i + 1) + ": ");
            for (int nonAnagram : nonAnagramArray[i]) {
                System.out.print(nonAnagram + " ");
            }
            System.out.println();
        }
    }
}
