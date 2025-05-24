package com.expenseTracker;

import java.io.Serializable;

public class Expense implements Serializable {
    private String description;
    private double amount;
    private String category;
    private String date;

    public Expense(String description, double amount, String category, String date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | " + description + " - $" + amount;
    }
}
