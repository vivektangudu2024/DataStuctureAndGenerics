package com.day14.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeAnagramPalindrome {

    public static void main(String[] args) {
        System.out.println("Prime numbers that are Anagram and Palindrome in the range of 0 to 1000:");

        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i) && isPalindrome(i) && hasAnagramPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Method to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Method to check if a number is palindrome
    private static boolean isPalindrome(int number) {
        String strNum = String.valueOf(number);
        return strNum.equals(new StringBuilder(strNum).reverse().toString());
    }

    // Method to check if a number has an anagram prime
    private static boolean hasAnagramPrime(int number) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        for (int prime : primes) {
            if (areAnagrams(number, prime)) {
                return true;
            }
        }

        return false;
    }

    // Method to check if two numbers are anagrams
    private static boolean areAnagrams(int num1, int num2) {
        char[] charArray1 = String.valueOf(num1).toCharArray();
        char[] charArray2 = String.valueOf(num2).toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}
