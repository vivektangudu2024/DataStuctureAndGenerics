package com.day14.algorithms;

import java.util.Scanner;



public class InsertionSort<T extends Comparable<T>> {

    public static void main(String[] args) {
        getUserInput();


    }

    private static <T extends Comparable<T>> void getUserInput() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create an array to store the elements
        T[] elements = (T[]) new Comparable[n];

        // Prompt the user to enter the elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            elements[i] = (T) scanner.next();
        }

        // Print the unsorted list
        System.out.println("\nUnsorted List:");
        printArray(elements);

        // Perform Insertion Sort
        insertionSort(elements);

        // Print the sorted list
        System.out.println("\nSorted List:");
        printArray(elements);

    }

    private static <T extends Comparable<T>> void insertionSort(T[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    private static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
