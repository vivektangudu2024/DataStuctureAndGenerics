package com.day14.algorithms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageCustomization {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the message
        System.out.println("Enter the message:");
        String message = scanner.nextLine();

        // Replace placeholders in the message using regex
        String customizedMessage = customizeMessage(message);

        // Output the modified message
        System.out.println("Modified Message:");
        System.out.println(customizedMessage);
    }

    private static String customizeMessage(String message) {
        // Replace <<name>> with first name (Assuming "John" as the user's first name)
        message = message.replaceAll("<<name>>", "John");

        // Replace <<full name>> with user's full name (Assuming "John Doe" as the user's full name)
        message = message.replaceAll("<<full name>>", "John Doe");

        // Replace mobile number format 91-xxxxxxxxxx with a sample contact number
        message = message.replaceAll("91-\\d{10}", "91-9876543210");

        // Replace date format XX/XX/XXXX with the current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", currentDate);

        return message;
    }
}
