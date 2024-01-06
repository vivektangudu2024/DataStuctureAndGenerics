package com.day14.datastructures;

import java.util.Arrays;



class LinkedLit {
    Node front, rear;

    public LinkedLit() {
        this.front = this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public int dequeue() {
        if (this.front == null) {
            return -1; // Assuming -1 as an invalid value indicating an empty queue
        }
        int data = (int) this.front.data;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return this.front == null;
    }
}

public class AnagramPrimeQueue {

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
        LinkedLit queue = new LinkedLit();

        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i)) {
                for (int j = i + 1; j <= 1000; j++) {
                    if (isPrime(j) && areAnagrams(i, j)) {
                        queue.enqueue(i);
                        queue.enqueue(j);
                    }
                }
            }
        }

        System.out.println("Prime Anagrams from the Queue:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
