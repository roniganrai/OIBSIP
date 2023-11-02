package atmpackage;

import java.util.Scanner;

class Withdraw {

	private int userId;
    private Database db;
    private final double[] availableAmounts = {100, 200, 500, 1000, 2000, 5000, 10000};

    public Withdraw(int userId, Database db) {
        this.userId = userId;
        this.db = db;
    }

    public void doWithdraw() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select an amount to withdraw:");
        for (int i = 0; i < availableAmounts.length; i++) {
            System.out.println((i + 1) + ". Rs." + availableAmounts[i]);
        }

        System.out.print("Enter your choice (1-7): ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= availableAmounts.length) {
            double selectedAmount = availableAmounts[choice - 1];
            double balance = db.getUserBalance(userId);

            if (balance >= selectedAmount) {
                double newBalance = balance - selectedAmount;
                db.updateUserBalance(userId, newBalance);
                System.out.println("Successfully withdrawn Rs." + selectedAmount);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
