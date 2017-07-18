package projecteuler.projecteuler.problems;

/***
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder. 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author Hare Kumar
 *
 */

public class Prob5 {

	private int lowerRange;
	private int higherRange;
	
	public Prob5() {
		this.lowerRange = 1;
		this.higherRange = 10;
	}
	
	public Prob5(int lower, int higher) {
		this.lowerRange = lower;
		this.higherRange = higher;
	}
	
	public static void main(String args[]) {
		long start = System.nanoTime();
		
		Prob5 p5 = new Prob5(1, 20);
		p5.findLCMofRange();
		
		long end = System.nanoTime();
		long diff = end - start;
		System.out.println("Start: " + start + " End: " + end + " Diff: " + diff + " Nanoseconds");
	}
	
	private void findLCMofRange() {
		Long smallestDivisbleNo = 1L;
		
		for(long i = this.lowerRange; i<= this.higherRange; i++) {
			smallestDivisbleNo = findLCM(smallestDivisbleNo, i);
		}
		
		
		/* Brute force implementation
		 * boolean cond = true;
		 * while(cond) {
			int count = 0;
			for(int i = this.lowerRange; i<= this.higherRange; i++) {
				if(smallestDivisbleNo % i == 0) {
					count++;
				} else {
					smallestDivisbleNo++;
					break;
				}
			}
			if(count == this.higherRange)
				cond = false;
		}*/
		
		System.out.println("SmallestDivisibleNo: " + smallestDivisbleNo);
	}
	
	private Long findLCM(Long a, Long b) {
		
		long lcm = 1, hcf = 1;
	    hcf = findGCM(a, b);
	    lcm=(a*b)/hcf;	
	    return lcm;
	}
	
	// Euclidean algorithm to find GCM
	private Long findGCM(long a, long b) {
		while(b > 0) {
			a %= b;
			if(a == 0 ) return b;
			b %= a;
		}
		return a;
	}
	
}
