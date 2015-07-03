/**
 * 
 */
package algorithms.n0191.NumberOf1Bits;

/**
 * @author upgitty
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.hammingWeight(Integer.MAX_VALUE));
	}

	/**
	 * Calculates the hamming weight (number of set bits) of the given integer
	 * 
	 * @param m - the number whose number of 1 bits are to be calculated
	 * @return the count of the number of bits set 
	 */
	public int hammingWeight(int m) {
         int count = 0;
         //if we do : while(n > 0) .. it does not work because Java does not have 
         //unsigned integers and numbers larger than Integer range will be considered as negative
         //Therefore: we loop for 32 times exactly
         for (int i = 0; i < 32; ++i) {
             count += m & 1;
             m = m >>> 1;		//This is unsigned right shift 
         }
         return count;
    }
}
