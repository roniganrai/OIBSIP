package atmpackage;

import java.util.Scanner;

class Transfer {
	
	private int userId;
    private Database db;

    public Transfer(int userId, Database db) {
        this.userId = userId;
        this.db = db;
    }

    public void doTransfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the recipient's User ID: ");
        int recipientId = sc.nextInt();
        System.out.print("Enter the amount to transfer: Rs.");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
        } else {
            double senderBalance = db.getUserBalance(userId);

            if (senderBalance >= amount) {
                double newSenderBalance = senderBalance - amount;

                double recipientBalance = db.getUserBalance(recipientId);
                double newRecipientBalance = recipientBalance + amount;

                db.updateUserBalance(userId, newSenderBalance);
                db.updateUserBalance(recipientId, newRecipientBalance);

                System.out.println("Successfully transferred Rs." + amount + " to User " + recipientId);
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }

}
