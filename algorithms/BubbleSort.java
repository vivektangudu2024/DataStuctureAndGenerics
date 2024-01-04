package com.day14.algorithms;

import java.util.Scanner;

public class BubbleSort<T extends Comparable<T>> {

    public static void main(String[] args) {
        Integer[] integers = getUserInput();

        // Print the unsorted list
        System.out.println("\nUnsorted List:");
        printArray(integers);

        // Perform Bubble Sort
        bubbleSort(integers);

        // Print the sorted list
        System.out.println("\nSorted List:");
        printArray(integers);
    }

    private static Integer[] getUserInput() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create an array to store the elements
        Integer[] elements = new Integer[n];

        // Prompt the user to enter the elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            elements[i] = scanner.nextInt();
        }

        return elements;
    }

    private static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // swap temp and arr[i]
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
