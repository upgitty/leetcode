/**
 * 
 */
package algorithms.n0204.CountPrimes;

/**
 * @author upgitty
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countPrimes(2));
		System.out.println(solution.isPrime(1245867));
	}
	
	/**
	 * Time Complexity: O(n)
	 * 
	 * @param n
	 * @return
	 */
    public int countPrimes(int n) {
    	if(n == 0 || n == 1) {
    		return 0;
    	}
    	
        boolean[] numbers = new boolean[n];		//Tells whether a number is composite
        for(int i=2; i<n; i++) {
        	int num = i + i;
        	while(num < n) {        		
        		numbers[num] = true;
        		num += i;
        	}
        }
        
        int count = 0;
        for(int i=2; i<n; i++) {
        	if(!numbers[i]) {
        		count++;
        	}
        }
        return count;
    }

    public boolean isPrime(int N) {
    	
    	int n = N+1;
    	if(n == 0 || n == 1) {
    		return false;
    	}
    	
        boolean[] numbers = new boolean[n];		//Tells whether a number is composite
        for(int i=2; i<n; i++) {
        	if(numbers[i]) {        		
        		int num = i + i;
        		while(num < n) {        		
        			numbers[num] = true;
        			num += i;
        			if(num == N) {
        				return false;
        			}
        			
        		}
        	}
        }
        
        return !numbers[N];
    }
}
