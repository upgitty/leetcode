package algorithms.n0001.TwoSum;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array = {-1,-2,-3,-4,-5};
		int[] indices = solution.twoSum(array, -8);
		System.out.println("index1=" + indices[0] + ", index2=" + indices[1]);
	}

	/**
	 * Function to check whether a 2 sum exists
	 * 
	 * @param arr - array of integers
	 * @return true if 2 sum exists
	 */
	public boolean twoSumExists(int[] arr) {
		if (arr.length < 2) {
			return false;
		}

		Arrays.sort(arr);

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {

			int sum = arr[i] + arr[j];
			if (sum == 0) {
				return true;
			} else if (sum < 0) {
				i++;
			} else {
				j--;
			}
		}

		return false;
	}

	/**
	 * This is an object that holds the value as well as the original position 
	 * of that value in the array before sorting
	 * 
	 * @author upgitty
	 *
	 */
	private class Number implements Comparable<Number> {
		int value;
		int originalPosition;

		public Number(int value, int originalPosition) {
			super();
			this.value = value;
			this.originalPosition = originalPosition;
		}

		@Override
		public int compareTo(Number n2) {
			return this.value - n2.value;
		}

	}

	/**
	 * Finds 2 numbers that sum up to the specified target
	 * @param arr - array of integers
	 * @param target - the target value
	 * @return the indexes of 2 numbers in the given array that sum up to the specified target
	 */
	public int[] twoSum(int[] arr, int target) {

		//if array length is less than 2 then we don't have a solution
		if (arr.length < 2) {
			return new int[] { -1, -1 };
		}

		//Create the Number[]
		Number[] numbers = new Number[arr.length];
		for (int i = 0; i < arr.length; i++) {
			numbers[i] = new Number(arr[i], i);
		}
		
		//Sort the Number[]
		Arrays.sort(numbers);

		int i = 0;
		int j = numbers.length - 1;

		while (i < j) {

			int sum = numbers[i].value + numbers[j].value;
			if (sum == target) {
				//We return the original positions of the Numbers
				int pos1 = numbers[i].originalPosition < numbers[j].originalPosition ? numbers[i].originalPosition + 1 : numbers[j].originalPosition + 1;
				int pos2 = numbers[i].originalPosition > numbers[j].originalPosition ? numbers[i].originalPosition + 1 : numbers[j].originalPosition + 1;
				return new int[] { pos1, pos2 };
			} else if (sum < target) {
				i++;	//increment the start index
			} else {
				j--;	//decrement the end index
			}
		}

		return new int[] { -1, -1 };
	}
}
