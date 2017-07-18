package projecteuler.projecteuler.problems;

/***
 * Problem statement:
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime factor of the number 600851475143 ?
 * 
 * @author Hare Kumar
 *
 */

public class Prob3 {

	private Long no;
	
	public Prob3() {
		this.no = 600851475143L;
	}
	
	public Prob3(Long n) {
		this.no = n;
	}

	public static void main(String args[]) {
		long start = System.currentTimeMillis();
		
		Prob3 p3 = new Prob3(600851475143L);
		p3.findPrimeFactors();
		
		long end = System.currentTimeMillis();
		double diff = (end - start) / 1000.0;
		System.out.println("Start: " + start + " End: " + end + " Diff: " + diff + " Seconds");
	}
	
	private void findPrimeFactors() {
		Long largest = 0L;
		
		for(long i=1; i< Math.sqrt(no); i++) {
			if (no % i == 0 && isPrime(i)) {
				largest = i;
			}
		}
		
		System.out.println("Largest prime factor is: " + largest);
	}
	
	private boolean isPrime(Long number) {
		long count = 0;
		for(long i = 2; i<=Math.sqrt(number); i++) {
			if (number % i == 0)
				count++;
		}
		
		if(count > 0)
			return false;
		else
			return true;
	}
}
