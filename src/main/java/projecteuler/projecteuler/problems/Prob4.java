package projecteuler.projecteuler.problems;

/***
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author Hare Kumar
 *
 */

public class Prob4 {

	private int rangeOfDigit;
	
	public Prob4() {
		this.rangeOfDigit = 2;
	}
	
	public Prob4(int range) {
		this.rangeOfDigit = range;
	}
	
	// TODO Fix DRY; Context: Benchmarking
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Prob4 p4 = new Prob4(3);
		p4.findLargestPalindrome();
		
		long end = System.currentTimeMillis();
		long diff = end -start;
		System.out.println("Start: " + start + " End: " + end + " Diff: " + diff + " Milli Seconds");
	}
	
	private void findLargestPalindrome() {
		Long largestNoOfRange = getLargestNoOfRange(this.rangeOfDigit);
		Long smallestNoOfRange = getSmallestNoOfRange(this.rangeOfDigit);
		long max = 100001L;
		
		for(long i = largestNoOfRange; i >= smallestNoOfRange; i--) {
			for(long j = largestNoOfRange; j >= smallestNoOfRange; j--) {
				long mul = i * j;
				
				if(max < mul && isPalindrome(mul)) {
					max = mul;
				}
			}
		}
		
		System.out.println(max);
	}
	
	private boolean isPalindrome(Long number) {
	
		long n = number;
		long rev = 0;
		
		// 101 
		while(n > 0) {
			long dig = n % 10;
			rev = rev * 10 + dig;
			n = n /10;
		}
		
		if(number == rev)
			return true;
		else
			return false;
	}
	
	private Long getLargestNoOfRange(int range) {
		String no = "";
		for(int i = 1; i<= range; i++) {
			no += "9";
		}
		
		Long largestNoOfRange = Long.parseLong(no);
		System.out.println("Largest number of range " + range + " is: " + largestNoOfRange);
		return largestNoOfRange;
	}
	
	private Long getSmallestNoOfRange(int range) {
		return getLargestNoOfRange(range-1) + 1;
	}

}
