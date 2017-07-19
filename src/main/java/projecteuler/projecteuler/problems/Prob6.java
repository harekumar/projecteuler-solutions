package projecteuler.projecteuler.problems;

/***
 * 
 * The sum of the squares of the first ten natural numbers is, 
 * 
 * 1^2 + 2^2 + ... + 10^2 = 385 
 * 
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)^2 = 55^2 = 3025 
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers and 
 * the square of the sum is 3025 − 385 = 2640. Find the difference between the sum of the squares of 
 * the first one hundred natural numbers and the square of the sum.
 * 
 * @author Hare Kumar
 *
 */
public class Prob6 {
	
	private int fRange;
	private int lRange;
	
	public Prob6() {
		this.fRange = 1;
		this.lRange = 10;
	}
	
	public Prob6(int f, int l) {
		this.fRange = f;
		this.lRange = l;
	}
	
	public static void main(String args[]) {
		long start = System.nanoTime();
		
		Prob6 p6 = new Prob6(5, 10);
		p6.calculate();
		
		long end = System.nanoTime();
		long diff = end -start;
		System.out.println("Start: " + start + " End: " + end + " Diff: " + diff + " Nanoseconds");
		
	}
	
	private void calculate() {
		int sumOfSquares = 0;
		int sumOfNosOfSquare = 0;
		
		sumOfSquares = calculateSumOfSquaresOfRange();
		sumOfNosOfSquare = calculateSumOfNosOfSquareInRange();
		
		int diff = Math.abs(sumOfNosOfSquare - sumOfSquares);
		
		System.out.println("Diffrence is: " + diff);
	}
	
	/***
	 * 
	 *  sum of squares of 1st n positive integer is
	 *  
	 *  n(n+1)(2n+1)/6
	 * 
	 * @return
	 */
	private Integer calculateSumOfSquaresOfRange() {
		int sum = 0;
		/*for(int i =this.fRange; i <= this.lRange; i++) {
			sum += i*i;
		}*/
		
		if (fRange > 1)
			sum += (this.lRange * (this.lRange +1) * (2*this.lRange + 1))/6 - (this.fRange * (this.fRange + 1) * (2*this.fRange + 1))/6;
		else
			sum += (this.lRange * (this.lRange +1) * (2*this.lRange + 1))/6;
		
		System.out.println("calculateSumOfSquaresOfRange: " + sum);
		return sum;
	}
	
	/***
	 * Sum of n positive integer is 
	 *
	 * sum = n(n+1)/2
	 * 
	 * @return
	 */
	private Integer calculateSumOfNosOfSquareInRange() {
		int sum = 0;
		/*for(int i =this.fRange; i <= this.lRange; i++) {
			sum += i;
		}*/
		if(fRange > 1)
			sum += (this.lRange * (this.lRange +1))/2;
		else
			sum += (this.lRange * (this.lRange +1))/2 - (this.fRange * (this.fRange +1))/2;
		
		System.out.println("calculateSumOfNosOfSquareInRange: " + sum);
		return sum * sum;
	}
}
