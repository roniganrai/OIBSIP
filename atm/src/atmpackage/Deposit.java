package atmpackage;

import java.util.Scanner;

class Deposit {
	
	private int userId;
    private Database db;

    public Deposit(int userId, Database db) {
        this.userId = userId;
        this.db = db;
    }

    public void doDeposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            double balance = db.getUserBalance(userId);

            double newBalance = balance + amount;
            db.updateUserBalance(userId, newBalance);
            System.out.println("Successfully deposited Rs." + amount);
        }
    }
}
