package GuessTheNumber;

public class Number {
	private int number;
	private int[] numberArray;
	
	public Number(int a, int digit) {
		this.number = a;
		this.numberArray = new int[digit];
		int numReplica = this.number;
		for (int k = digit-1; k >= 0; k--) {
			double numberN = numReplica / 10;
			int numberint = (int) numberN;
			int x = numReplica - numberint * 10;
			this.numberArray[k] = x;
			numReplica = (int) numReplica / 10;
		}
	}
	
	public int getNum() {
		return number;
	}
	
	public int getX(int k) {
		return this.numberArray[k];
	}
	
	public void printN() {
		System.out.println(this.number);
	}
	

}
