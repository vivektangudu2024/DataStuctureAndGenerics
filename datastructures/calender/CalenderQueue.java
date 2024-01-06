package com.day14.datastructures.calender;


class WeekDay {
    String day;
    String date;

    public WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }
}
class Node {
    WeekDay data;
    Node next;

    public Node(WeekDay data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(WeekDay data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public WeekDay dequeue() {
        if (this.front == null) {
            return null; // Assuming null as an invalid value indicating an empty queue
        }
        WeekDay data = this.front.data;
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

public class CalenderQueue {

    public static void main(String[] args) {
        Queue calendarQueue = new Queue();

        // Add days to the calendar week
        calendarQueue.enqueue(new WeekDay("Sun", "1"));
        calendarQueue.enqueue(new WeekDay("Mon", "2"));
        calendarQueue.enqueue(new WeekDay("Tue", "3"));
        calendarQueue.enqueue(new WeekDay("Wed", "4"));
        calendarQueue.enqueue(new WeekDay("Thu", "5"));
        calendarQueue.enqueue(new WeekDay("Fri", "6"));
        calendarQueue.enqueue(new WeekDay("Sat", "7"));

        // Display the calendar
        displayCalendar(calendarQueue);
    }

    public static void displayCalendar(Queue calendarQueue) {
        while (!calendarQueue.isEmpty()) {
            WeekDay currentDay = calendarQueue.dequeue();
            System.out.printf("%-3s %-2s ", currentDay.day, currentDay.date);
        }
        System.out.println();
    }
}
