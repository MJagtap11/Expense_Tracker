package com.expenseTracker;

import java.io.*;
import java.util.ArrayList;

public class ExpenseManager {
    private ArrayList<Expense> expenses;
    private final String FILE_NAME = "expenses.dat";

    public ExpenseManager() {
        expenses = loadExpenses();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses();
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            System.out.println("\n--- All Expenses ---");
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }
    }

    public void showTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        System.out.println("Total Expenses: $" + total);
    }

    private void saveExpenses() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(expenses);
        } catch (IOException e) {
            System.out.println("Error saving expenses.");
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Expense> loadExpenses() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Expense>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
