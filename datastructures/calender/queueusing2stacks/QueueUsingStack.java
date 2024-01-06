package com.day14.datastructures.calender.queueusing2stacks;

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

class Stack {
    Node top;

    public Stack() {
        this.top = null;
    }

    public void push(WeekDay data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public WeekDay pop() {
        if (top == null) {
            return null; // Assuming null as an invalid value indicating an empty stack
        }
        WeekDay data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class Queue {
    Stack stack1, stack2;

    public Queue() {
        this.stack1 = new Stack();
        this.stack2 = new Stack();
    }

    public void enqueue(WeekDay data) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(data);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public WeekDay dequeue() {
        if (stack1.isEmpty()) {
            return null; // Assuming null as an invalid value indicating an empty queue
        }
        return stack1.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}

public class QueueUsingStack {

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
