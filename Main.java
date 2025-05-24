package com.expenseTracker;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ExpenseManager manager = new ExpenseManager();
		int choice;

		do {
			System.out.println("\n===== Expense Tracker =====");
			System.out.println("1. Add Expense");
			System.out.println("2. View All Expenses");
			System.out.println("3. Show Total Expenses");
			System.out.println("4. Exit");
			
			System.out.println("Choose an option: ");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter Description: ");
				String desc = scanner.nextLine();

				System.out.println("Enter Amount: ");
				double amount = scanner.nextDouble();

				System.out.println("Enter Category: ");
				String category = scanner.nextLine();

				System.out.println("Enter Date: (YYYY-MM-DD): ");
				String date = scanner.nextLine();

				Expense expense = new Expense(desc, amount, category, date);
				manager.addExpense(expense);

				System.out.println("Expense added successfully!!!");
				break;
			case 2:
				manager.viewExpenses();
				break;
			case 3:
				manager.showTotal();
				break;
			case 4:
				System.out.println("Exiting Expense Tracker. Goodbye!");
				break;

			default:
				System.out.println("Invalid Choice. Please try again.");
			}
		} while (choice != 4);

		scanner.close();
	}
}
