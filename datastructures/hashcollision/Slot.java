package com.day14.datastructures.hashcollision;

import java.io.*;
import java.util.*;

class Slot {
    private Map<Integer, LinkedList<Integer>> slotMap;

    public Slot() {
        this.slotMap = new HashMap<>();
    }

    public void insert(int number) {
        int slotNumber = number % 11;
        LinkedList<Integer> slotList = slotMap.computeIfAbsent(slotNumber, k -> new LinkedList<>());
        slotList.add(number);
    }

    public void searchAndOperate(int number) {
        int slotNumber = number % 11;
        LinkedList<Integer> slotList = slotMap.get(slotNumber);

        if (slotList != null) {
            if (slotList.contains(number)) {
                slotList.remove((Integer) number); // Remove the number if found
                System.out.println(number + " found and removed.");
            } else {
                slotList.add(number); // Add the number if not found
                System.out.println(number + " not found and added.");
            }
        } else {
            System.out.println("Slot " + slotNumber + " is empty. " + number + " added.");
            slotMap.put(slotNumber, new LinkedList<>(Collections.singletonList(number)));
        }
    }

    public void display() {
        for (Map.Entry<Integer, LinkedList<Integer>> entry : slotMap.entrySet()) {
            int slotNumber = entry.getKey();
            LinkedList<Integer> slotList = entry.getValue();

            System.out.print("Slot " + slotNumber + ": ");
            for (int num : slotList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Map.Entry<Integer, LinkedList<Integer>> entry : slotMap.entrySet()) {
                LinkedList<Integer> slotList = entry.getValue();
                for (int num : slotList) {
                    writer.println(num);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

