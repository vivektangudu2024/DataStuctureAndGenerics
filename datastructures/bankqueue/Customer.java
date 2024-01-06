package com.day14.datastructures.bankqueue;

class Customer {
    private String name;
    private boolean isDeposit;
    private int amount;

    public Customer(String name, boolean isDeposit, int amount) {
        this.name = name;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public int getAmount() {
        return amount;
    }
}
