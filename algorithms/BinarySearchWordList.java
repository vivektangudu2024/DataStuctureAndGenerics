package com.day14.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWordList {

    public static void main(String[] args) {
        // File path containing the list of words
        String filePath = "wordList.txt";

        // Read the list of words from the file
        String[] wordList = readWordListFromFile(filePath);

        if (wordList != null) {
            // Sort the word list
            Arrays.sort(wordList);

            // Prompt the user to enter a word to search
            String searchWord = getUserInput("Enter a word to search: ");

            // Perform binary search
            boolean isWordFound = binarySearch(wordList, searchWord);

            // Print the result
            if (isWordFound) {
                System.out.println("The word '" + searchWord + "' is found in the list.");
            } else {
                System.out.println("The word '" + searchWord + "' is not found in the list.");
            }
        }
    }

    // Method to read the list of words from a file
    private static String[] readWordListFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                // Split the comma-separated words into an array
                return line.split(",");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return null;
    }

    // Method to perform binary search on a sorted array
    private static boolean binarySearch(String[] wordList, String searchWord) {
        int left = 0;
        int right = wordList.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparisonResult = searchWord.compareTo(wordList[mid]);

            if (comparisonResult == 0) {
                return true; // Word found
            } else if (comparisonResult < 0) {
                right = mid - 1; // Search in the left half
            } else {
                left = mid + 1; // Search in the right half
            }
        }

        return false; // Word not found
    }

    // Method to get user input
    private static String getUserInput(String prompt) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }


}
