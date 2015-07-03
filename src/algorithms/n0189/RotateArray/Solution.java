/**
 * 
 */
package algorithms.n0189.RotateArray;

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
		int[] nums = {1, 2};
		solution.rotate(nums, 1);
		
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}

	/**
	 * Time complexity : O(n)
	 * 
	 * @param nums
	 * @param k
	 */
    public void rotate(int[] nums, int k) {
    	k = k % nums.length;
    	
    	int f = nums.length - k;
        reverse(nums, 0, f-1);
        reverse(nums, f, nums.length - 1);
        reverse(nums, 0 , nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
    	if(nums == null || nums.length == 1) {
    		return;
    	}
    	
    	while(start < end && start>=0 && end < nums.length) {
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++; end--;
    	}
    }
    
}
