package com.day14.datastructures.palindormechecker;

import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindrome(String input) {
        Deque<Character> deque = new Deque<>();

        // Process the string from left to right and add each character to the rear of the deque
        for (char ch : input.toCharArray()) {
            deque.addRear(ch);
        }

        // Check if the string is a palindrome by comparing characters from both ends of the deque
        while (deque.size() > 1) {
            if (!deque.removeFront().equals(deque.removeRear())) {
                return false; // Characters from both ends don't match, not a palindrome
            }
        }

        return true; // All characters matched, the string is a palindrome
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take a string as input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Check if the string is a palindrome
        boolean result = isPalindrome(input);

        // Display the result
        System.out.println("Is the string a palindrome? " + result);
    }
}
