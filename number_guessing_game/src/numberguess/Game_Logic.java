package numberguess;

import java.util.Scanner;

class Game_Logic {
	
	private Scanner sc;
    boolean Play_Again;

    public Game_Logic(Scanner sc) {
        this.sc = sc;
    }

    public void play() {
        do {
            int User_Guess = 0;
            int Number_of_Attempts = 1;

            System.out.println();
            System.out.println("***Welcome To The Number Guessing Game***");
            System.out.println();
            System.out.println("Select a difficulty level:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.println();
            System.out.print("Enter Your Choice : ");

            int choice = sc.nextInt();

            Difficulty_Level Difficulty = null;

            switch (choice) {
                case 1:
                    Difficulty = new Difficulty_Level(1, 50, 10);
                    break;
                case 2:
                    Difficulty = new Difficulty_Level(1, 100, 7);
                    break;
                case 3:
                    Difficulty = new Difficulty_Level(1, 200, 5);
                    break;
                default:
                    System.out.println("Invalid choice...Defaulting The Game to Easy Mode.");
                    Difficulty = new Difficulty_Level(1, 50, 10);
            }

            Computer_Guess computerGuess = new Computer_Guess(Difficulty);

            System.out.println("I have generated a random number between (" + Difficulty.getMinRange() + "-" + Difficulty.getMaxRange() + ")");
            System.out.println("You Have " + Difficulty.getMaxGuesses() + " Attempts to Guess");
            System.out.println("Try to guess it...");
            System.out.println("Let's Start the Game");

            User_Input userInput = new User_Input(sc);

            do {

                if (Number_of_Attempts > Difficulty.getMaxGuesses()) {
                    System.out.println("Sorry, You have reached The Maximum Number of Attempts...");
                    break;
                }

                System.out.println();
                System.out.print("Guess My Number : ");
                User_Guess = userInput.getUserGuess();

                if (User_Guess == computerGuess.getComputerGuess()) {
                    System.out.println("WOOHOO...You guessed the correct number in " + Number_of_Attempts + " attempts");
                    break;

                } else if (User_Guess <= 0 || User_Guess > Difficulty.getMaxRange()) {
                    System.out.println("Invalid Input.... ");
                    System.out.println("Thank You For Playing!");
                    System.exit(1);

                } else if (User_Guess > computerGuess.getComputerGuess()) {
                    System.out.println("Your Number is large");
                } else {
                    System.out.println("Your Number is small");
                }

                Number_of_Attempts++;

            } while (User_Guess != computerGuess.getComputerGuess());

            System.out.println("My number was : " + computerGuess.getComputerGuess());

            System.out.print("Do You Want to Play Again? (Yes/No): ");

            String playAgainInput = sc.next().toLowerCase();
            Play_Again = playAgainInput.equals("yes");

        } while (Play_Again);
    }
}
