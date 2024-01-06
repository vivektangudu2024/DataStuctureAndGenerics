package com.day14.datastructures;

import java.io.*;
import java.util.Scanner;



class UnorderedList<T extends Comparable<T>> {
    private Node<T> head;

    public UnorderedList() {
        this.head = null;
    }

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
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

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public void append(T item) {
        Node<T> newNode = new Node<>(item);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
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
        UnorderedList<String> wordList = new UnorderedList<>();
        Scanner scanner = new Scanner(System.in);

        // Read from file and populate the list
        try (BufferedReader reader = new BufferedReader(new FileReader("wordList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // User input to search or add a word
        System.out.print("Enter a word to search or add: ");
        String userInput = scanner.nextLine();

        if (wordList.search(userInput)) {
            wordList.remove(userInput);
            System.out.println(userInput + " removed from the list.");
        } else {
            wordList.add(userInput);
            System.out.println(userInput + " added to the list.");
        }

        // Save the updated list to file
        wordList.saveToFile("wordList.txt");

        // Display the final list
        System.out.print("Updated Word List: ");
        wordList.display();
    }
}
