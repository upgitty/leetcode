/**
 * 
 */
package algorithms.n0049.Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		System.out.println(solution.anagrams(new String[] { "" }));

	}

	/**
	 * Find anagram words
	 * 
	 * Time complexity : O(n*mlogm) + O(n) = O(nmlogm)
	 * Space Complexity : O(n)
	 * 
	 * @param strs - an array of the strings to test
	 * @return a list of strings that are anagrams
	 */
	public List<String> anagrams(String[] strs) {
		//Map -- Key: sorted string, Value: list of original words
		Map<String, List<String>> map = new HashMap<>();

		//Final result to return
		List<String> result = new ArrayList<String>();
		
		//If less than 2 strings, then no groups
		if (strs.length < 2) {
			return result;
		}

		//For each string
		for (String str : strs) {
			char[] chars = str.toCharArray();		//Convert to character array to sort
			Arrays.sort(chars);						//Sort the characters
			String sorted = new String(chars);		//Convert to string again
			List<String> list = map.get(sorted);	

			if (list == null) {
				list = new ArrayList<String>();
				map.put(sorted, list);
			}
			list.add(str);
		}

		//Iterate through the map and find the biggest set
		for (String key : map.keySet()) {
			List<String> l = map.get(key);
			if (l.size() > 1 && l.size() > result.size()) {
				result = l;
			}
		}

		return result;
	}

}
