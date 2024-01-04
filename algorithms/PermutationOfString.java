package com.day14.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationOfString {

    // Iterative method to generate all permutations of a string
    public static List<String> generatePermutationsIterative(String input) {
        List<String> permutations = new ArrayList<>();
        permutations.add(""); // Initial empty permutation

        for (char currentChar : input.toCharArray()) {
            List<String> newPermutations = new ArrayList<>();
            for (String permutation : permutations) {
                for (int i = 0; i <= permutation.length(); i++) {
                    newPermutations.add(permutation.substring(0, i) + currentChar + permutation.substring(i));
                }
            }
            permutations = newPermutations;
        }

        return permutations;
    }

    // Recursive method to generate all permutations of a string
    public static List<String> generatePermutationsRecursive(String input) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsRecursiveHelper("", input, permutations);
        return permutations;
    }

    private static void generatePermutationsRecursiveHelper(String prefix, String remaining, List<String> permutations) {
        int length = remaining.length();
        if (length == 0) {
            permutations.add(prefix);
            return;
        }

        for (int i = 0; i < length; i++) {
            generatePermutationsRecursiveHelper(prefix + remaining.charAt(i),
                    remaining.substring(0, i) + remaining.substring(i + 1),
                    permutations);
        }
    }

    // Method to check if two arrays (representing permutations) are equal
    public static boolean arePermutationsEqual(List<String> perms1, List<String> perms2) {
        return new HashSet<>(perms1).equals(new HashSet<>(perms2));
    }

    public static void main(String[] args) {
        String input = "abc";

        // Generate permutations using iterative method
        List<String> permsIterative = generatePermutationsIterative(input);

        // Generate permutations using recursive method
        List<String> permsRecursive = generatePermutationsRecursive(input);

        // Check if the arrays are equal
        boolean areEqual = arePermutationsEqual(permsIterative, permsRecursive);

        System.out.println("Permutations (Iterative): " + permsIterative);
        System.out.println("Permutations (Recursive): " + permsRecursive);
        System.out.println("Are permutations equal: " + areEqual);
    }
}
