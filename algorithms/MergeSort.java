package com.day14.algorithms;

import java.util.Scanner;

public class MergeSort<T extends Comparable<T>> {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create an array to store the elements
        String[] elements = new String[n];

        // Prompt the user to enter the elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            elements[i] = scanner.next();
        }

        // Print the unsorted list
        System.out.println("\nUnsorted List:");
        printArray(elements);

        // Perform Merge Sort
        mergeSort(elements, 0, n - 1);

        // Print the sorted list
        System.out.println("\nSorted List:");
        printArray(elements);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int lo, int hi) {
        if (lo < hi) {
            // Find the middle point
            int mid = lo + (hi - lo) / 2;

            // Recursively sort the first and second halves
            mergeSort(array, lo, mid);
            mergeSort(array, mid + 1, hi);

            // Merge the sorted halves
            merge(array, lo, mid, hi);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        // Create temporary arrays
        T[] leftArray = (T[]) new Comparable[n1];
        T[] rightArray = (T[]) new Comparable[n2];

        // Copy data to temporary arrays
        System.arraycopy(array, lo, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        // Merge the temporary arrays
        int i = 0, j = 0, k = lo;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray, if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray, if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
