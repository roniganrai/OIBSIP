package numberguess;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Game_Logic run = new Game_Logic(sc);
		run.play();
		sc.close();
	}
}
