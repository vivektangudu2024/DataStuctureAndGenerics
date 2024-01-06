package com.day14.datastructures;

import java.io.*;
import java.util.Scanner;



class OrderedList<T extends Comparable<T>> {
    private Node<T> head;

    public OrderedList() {
        this.head = null;
    }

    public void insert(T item) {
        Node<T> newNode = new Node<>(item);

        if (head == null || head.data.compareTo(item) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.data.compareTo(item) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void remove(T item) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null && !current.data.equals(item)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
        }
    }

    public boolean search(T item) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            Node<T> current = head;
            while (current != null) {
                writer.println(current.data);
                current = current.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OrderedList<Integer> orderedList = new OrderedList<>();
        Scanner scanner = new Scanner(System.in);

        // Read from file and populate the ordered list
        try (BufferedReader reader = new BufferedReader(new FileReader("numberList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                orderedList.insert(num);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        // User input for a new number
        System.out.print("Enter a number: ");
        int userInput = scanner.nextInt();

        // Remove or insert the number in the appropriate position
        if (orderedList.search(userInput)) {
            orderedList.remove(userInput);
            System.out.println(userInput + " removed from the list.");
        } else {
            orderedList.insert(userInput);
            System.out.println(userInput + " inserted in the list.");
        }

        // Save the updated list to file
        orderedList.saveToFile("numberList.txt");

        // Display the final ordered list
        System.out.print("Updated Number List: ");
        orderedList.display();
    }
}
