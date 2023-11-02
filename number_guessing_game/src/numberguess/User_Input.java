package numberguess;

import java.util.Scanner;

class User_Input {
	
	private Scanner sc;

    public User_Input(Scanner sc) {
        this.sc = sc;
    }

    public int getUserGuess() {
        return sc.nextInt();
    }

}
