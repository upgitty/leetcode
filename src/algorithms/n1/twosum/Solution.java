package algorithms.n1.twosum;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array = {-1,-2,-3,-4,-5};
		int[] indices = solution.twoSum(array, -8);
		System.out.println("index1=" + indices[0] + ", index2=" + indices[1]);
	}

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

	public int[] twoSum(int[] arr, int target) {

		if (arr.length < 2) {
			return new int[] { -1, -1 };
		}

		Number[] numbers = new Number[arr.length];
		for (int i = 0; i < arr.length; i++) {
			numbers[i] = new Number(arr[i], i);
		}
		Arrays.sort(numbers);

		int i = 0;
		int j = numbers.length - 1;

		while (i < j) {

			int sum = numbers[i].value + numbers[j].value;
			if (sum == target) {
				int pos1 = numbers[i].originalPosition < numbers[j].originalPosition ? numbers[i].originalPosition + 1 : numbers[j].originalPosition + 1;
				int pos2 = numbers[i].originalPosition > numbers[j].originalPosition ? numbers[i].originalPosition + 1 : numbers[j].originalPosition + 1;
				return new int[] { pos1, pos2 };
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}

		return new int[] { -1, -1 };
	}
}
