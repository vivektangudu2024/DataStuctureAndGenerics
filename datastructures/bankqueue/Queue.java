package com.day14.datastructures.bankqueue;

class Queue<T> {
    private Object[] array;
    private int front, rear, size, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.front = this.size = 0;
        this.rear = capacity - 1;
    }

    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            rear = (rear + 1) % capacity;
            array[rear] = item;
            size++;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        } else {
            T item = (T) array[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }
}
