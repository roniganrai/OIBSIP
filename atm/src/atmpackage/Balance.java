package atmpackage;

class Balance {
	
	private int userId;
    private Database db;

    public Balance(int userId, Database db) {
        this.userId = userId;
        this.db = db;
    }

    public void viewBalance() {
        double balance = db.getUserBalance(userId);
        System.out.println("Your Account Balance is " + ": Rs." + balance);
    }
}
