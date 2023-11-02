package numberguess;

class Difficulty_Level {
	
	private int minRange;
	private int maxRange;
	private int maxGuesses;
	
	public Difficulty_Level(int minRange,int maxRange,int maxGuesses) {
		this.minRange=minRange;
		this.maxRange=maxRange;
		this.maxGuesses=maxGuesses;
	}
	
	public int getMinRange() {
		return minRange;
	}
	
	public int getMaxRange() {
		return maxRange;
	}
	
	public int getMaxGuesses() {
		return maxGuesses;
	}

}
