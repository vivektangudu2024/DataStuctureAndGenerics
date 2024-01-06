package com.day14.datastructures.palindormechecker;

import java.util.Scanner;

class Deque<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Deque() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void addFront(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        size++;
    }

    public void addRear(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public T removeFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }

        T data = front.data;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }

        size--;

        return data;
    }

    public T removeRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }

        T data = rear.data;

        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }

        size--;

        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

