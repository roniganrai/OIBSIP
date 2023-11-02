package atmpackage;

import java.util.Scanner;

class New_User {
	
	private Database db;

    public New_User(Database db) {
        this.db = db;
    }

    public void newUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Username: ");
        String userName = sc.nextLine();
        
        System.out.print("Enter a 4-Digit ATM PIN: ");
        int userPin = sc.nextInt();
        int userId = db.createUser(userName, userPin);
        
        System.out.println();
        System.out.println("Congrats, Your Account has been Successfully Created");
        System.out.println("Account User ID : " + userId);
        System.out.println("Login into Existing User and Perform");
    }
}
