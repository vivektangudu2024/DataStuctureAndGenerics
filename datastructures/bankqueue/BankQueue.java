package com.day14.datastructures.bankqueue;

class BankQueue {
    private int cashBalance;
    private Queue<Customer> customerQueue;

    public BankQueue() {
        this.cashBalance = 0;
        this.customerQueue = new Queue<>(10); // Specify the capacity of the queue
    }

    public void enqueue(Customer customer) {
        customerQueue.enqueue(customer);
        processQueue();
    }

    public void dequeue() {
        Customer customer = customerQueue.dequeue();
        if (customer != null) {
            if (customer.isDeposit()) {
                cashBalance += customer.getAmount();
                System.out.println(customer.getName() + " deposited $" + customer.getAmount());
            } else {
                if (cashBalance >= customer.getAmount()) {
                    cashBalance -= customer.getAmount();
                    System.out.println(customer.getName() + " withdrew $" + customer.getAmount());
                } else {
                    System.out.println("Insufficient funds for " + customer.getName() +
                            " to withdraw $" + customer.getAmount());
                }
            }
            processQueue();
        } else {
            System.out.println("Queue is empty.");
        }
    }

    private void processQueue() {
        if (!customerQueue.isEmpty()) {
            Customer frontCustomer = customerQueue.dequeue();
            customerQueue.enqueue(frontCustomer); // Move the front customer to the rear
            System.out.println("Current Customer: " + frontCustomer.getName() +
                    " - Cash Balance: $" + cashBalance);
        } else {
            System.out.println("Queue is empty. Cash Balance: $" + cashBalance);
        }
    }
}
