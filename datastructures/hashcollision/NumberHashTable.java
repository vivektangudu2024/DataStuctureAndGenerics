package com.day14.datastructures.hashcollision;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NumberHashTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Slot slot = new Slot();

        // Read numbers from a file and insert into the hash table
        try (BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                slot.insert(number);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Take user input to search and operate on numbers
        while (true) {
            System.out.print("Enter a number to search (or -1 to exit): ");
            int userInput = scanner.nextInt();

            if (userInput == -1) {
                break;
            }

            slot.searchAndOperate(userInput);
            slot.display();
        }

        // Save the numbers back to a file
        slot.saveToFile("updated_numbers.txt");

        System.out.println("Numbers after user operations saved to 'updated_numbers.txt'");
    }
}
