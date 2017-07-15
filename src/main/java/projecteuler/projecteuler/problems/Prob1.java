package projecteuler.projecteuler.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/***
 * Problem statement:
 *  
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * Log can be enabled by // private static Logger logger = Logger.getLogger(Prob1.class);
 * 
 * @author Hare Kumar
 *
 */
public class Prob1 {

	private List<Integer> input;
	private final int MAX;
	private int sum;
	
	public Prob1() {
		this.input = Arrays.asList(3,5);
		this.MAX = 10;
		this.sum = 0;
	}
	
	public Prob1(List<Integer> in) {
		this.input = in;
		this.MAX = 10;
		this.sum = 0;
	}
	
	public Prob1(int max) {
		this.input = Arrays.asList(3,5);
		this.MAX = max;
		this.sum = 0;
	}
	
	public Prob1(List<Integer> in, int max) {
		this.input = in;
		this.MAX = max;
		this.sum = 0;
	}
	
	public static void main(String args[]) {
		Prob1 p1 = new Prob1(1000);
		p1.calculateSum();
	}
	
	private void calculateSum() {
		HashSet<Integer> uniq = new HashSet<Integer>();
		
		// Time complexity: O(n^2)
		for(Integer i : input) {
			findMultiple(uniq, i);
		}
		
		Iterator<Integer> it = uniq.iterator();
		
		while (it.hasNext()) {
			sum += it.next();
		}
		
		System.out.println("Sum is: " + sum);
	}
	
	private void findMultiple(HashSet<Integer> u, Integer num) {
		int i = 0;
		while(i<MAX) {
			if(i % num == 0) {
				u.add(i);
				i += num;
			}
		}
	}
	
}
