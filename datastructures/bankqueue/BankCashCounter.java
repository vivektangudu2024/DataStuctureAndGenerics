package com.day14.datastructures.bankqueue;

import java.util.*;
public class BankCashCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankQueue bankQueue = new BankQueue();

        while (true) {
            System.out.println("1. Add Customer to Queue");
            System.out.println("2. Process Next Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.next();
                    System.out.print("Is the customer depositing? (true/false): ");
                    boolean isDeposit = scanner.nextBoolean();
                    System.out.print("Enter the amount: ");
                    int amount = scanner.nextInt();

                    Customer customer = new Customer(name, isDeposit, amount);
                    bankQueue.enqueue(customer);
                    break;
                case 2:
                    bankQueue.dequeue();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}