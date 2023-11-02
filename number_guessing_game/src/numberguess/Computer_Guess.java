package numberguess;

class Computer_Guess {
	
	private int Computer_Guess;
	
	public Computer_Guess(Difficulty_Level difficulty) {
		this.Computer_Guess = (int) (Math.random() * (difficulty.getMaxRange() - difficulty.getMinRange() + 1)) + difficulty.getMinRange();
		
	}
	
	public int getComputerGuess() {
		return Computer_Guess;
	}
}
