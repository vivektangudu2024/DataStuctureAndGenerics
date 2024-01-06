package com.day14.datastructures;

class Stack<T> {
    private Object[] array;
    private int top;
    private int maxSize;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        this.top = -1;
    }

    public void push(T element) {
        if (top == maxSize - 1) {
            System.out.println("Stack overflow");
        } else {
            array[++top] = element;
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return null;
        } else {
            return (T) array[top--];
        }
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return (T) array[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}