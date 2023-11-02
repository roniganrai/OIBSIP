package atmpackage;

import java.util.Scanner;

class ATM {
	
	private Database db;
    private int userId;

    public ATM() {
        db = new Database();
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        boolean again = true;

        while (again) {
            System.out.println();
            System.out.println("****Welcome to ATM****");
            System.out.println("---------------------");
            System.out.println("1. New User");
            System.out.println("2. Existing User");
            System.out.println("---------------------");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                New_User createAcc = new New_User(db);
                createAcc.newUser();
            } else if (choice == 2) {
                System.out.println();
                System.out.println("***WELCOME BACK***");
                System.out.print("Enter User ID: ");
                userId = sc.nextInt();
                System.out.print("Enter ATM PIN: ");
                int userPin = sc.nextInt();

                if (db.isValidUser(userId, userPin)) {
                    do {
                        menu();
                        System.out.println("Do you want to perform another operation?");
                        System.out.println("1. YES");
                        System.out.println("2. NO");
                        System.out.print("Select an option: ");
                        int select = sc.nextInt();
                        again = (select == 1);
                    } while (again);
                    System.out.println("Thank You, Visit Again!");
                } else {
                    System.out.println("Invalid User ID or PIN. Please try again.");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("ATM Menu   ");
        System.out.println("---------------------");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. View Balance");
        System.out.println("---------------------");
        System.out.print("Select an option: ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Withdraw withdraw = new Withdraw(userId, db);
                withdraw.doWithdraw();
                break;
            case 2:
                Deposit deposit = new Deposit(userId, db);
                deposit.doDeposit();
                break;
            case 3:
                Transfer transfer = new Transfer(userId, db);
                transfer.doTransfer();
                break;
            case 4:
                Balance viewBalance = new Balance(userId, db);
                viewBalance.viewBalance();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
