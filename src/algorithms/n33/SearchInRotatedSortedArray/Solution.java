/**
 * 
 */
package algorithms.n33.SearchInRotatedSortedArray;

/**
 * @author upgitty
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {4, 5, 6, 7, 0, 1, 2};
		Solution solution = new Solution();
		System.out.println(solution.search(array, 10));
	}
	
	/**
	 * Searches a value in a sorted and rotated integer array
	 * 
	 * @param nums - array to search
	 * @param target - value to search
	 * @return index of the target or -1 if does not exist
	 */
	public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

	/**
	 * Recursive function for the search
	 * 
	 * Time complexity : O(log n)
	 * 
	 * @param nums - array to search
	 * @param target - value to search
	 * @param startIdx - the starting index to start search from
	 * @param endIdx - the ending index to end the search
	 * @return index of the target or -1 if does not exist
	 */
	private int search(int[] nums, int target, int startIdx, int endIdx) {
		
		//The mid index is start + end / 2
		int midIdx = (startIdx + endIdx) / 2;
		
		//Find the start, mid and end values for comparison
		int start = nums[startIdx];
		int mid = nums[midIdx];
		int end = nums[endIdx];
		
		//Bases case : target is start
		if(target == start) {
			return startIdx;
		}
		
		//Bases case : target is mid
		if(target == mid) {
			return midIdx;
		}
		
		//Bases case : target is end
		if(target == end) {
			return endIdx;
		}
		
		//Base case : start and end are same or just 1 after the other 
		//and since start and end don't match from previous tests no match found return -1
		if(startIdx == endIdx || endIdx == startIdx + 1) {
			return -1;
		}
		
		
		if(start < mid && start <= target && target <= mid) {
			//in first half
			return search(nums, target, startIdx, midIdx);
		}else if(start > mid && !(mid <= target && target <= end)) {
			//in first half
			return search(nums, target, startIdx, midIdx);
		}else if(mid < end && mid <= target && target <= end) {
			//in second half
			return search(nums, target, midIdx, endIdx);
		}else if(mid > end && !(start <= target && target <= mid)) {
			//in second half
			return search(nums, target, midIdx, endIdx);
		}
		
		return -1;
	}
}
