package com.day14.datastructures;

import java.util.Arrays;



class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printReverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class AnagramPrimeStack {

    static boolean areAnagrams(int num1, int num2) {
        // Implement the logic to check if num1 and num2 are anagrams
        String str1 = Integer.toString(num1);
        String str2 = Integer.toString(num2);

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    static boolean isPrime(int num) {
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
        LinkedList stack = new LinkedList();

        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i)) {
                for (int j = i + 1; j <= 1000; j++) {
                    if (isPrime(j) && areAnagrams(i, j)) {
                        stack.push(i);
                        stack.push(j);
                    }
                }
            }
        }

        System.out.println("Prime Anagrams in Reverse Order:");
        stack.printReverse();
    }
}
