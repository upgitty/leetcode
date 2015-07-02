/**
 * 
 */
package algorithms.n214.ShortestPalindrome;

/**
 * @author upgitty
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.shortestPalindrome("abaa");
	}
	
	/**
	 * We need to find the shortest Palindrome string by inserting characters in the given string
	 * 
	 *  	ab = aba
	 *  	abc = abcba
	 *  	aaa = aaa
	 *  	abaa = ababa | aabaa
	 *  
	 * We compare characters one by one and insert character at the front or at the end and return the shortest string
	 * 
	 * Time Complexity : O(n) .. n is the length of the string
	 * 
	 * @param s - the string to be converted
	 * @return the palindrome string
	 */
    public String shortestPalindrome(String s) {
        if(s == null) {
        	return null;
        }
        
        if(s.isEmpty()) {
        	return "";
        }
        
        //Find shortest by inserting at end
    	char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length-1;
        int index = 0;
        
        StringBuilder result = new StringBuilder();
        while(start <= end) {
        	if(chars[start] == chars[end]) {
        		if(start == end) {
        			result.insert(index, chars[start]);
        			start++;
        			end--;
        		}else {        			
        			result.insert(index, chars[start]);
        			result.insert(index, chars[end]);
        			index++;
        			start++;
        			end--;
        		}
        	}else {
        		result.insert(index, chars[start]);
        		result.insert(index, chars[start]);
        		index++;
        		start++;
        	}
        }
        
        //Find shortest by inserting at start
        start = 0;
        end = chars.length-1;
        index = 0;
        StringBuilder result2 = new StringBuilder();
        while(start <= end) {
        	if(chars[start] == chars[end]) {
        		if(start == end) {
        			result2.insert(index, chars[start]);
        			start++;
        			end--;
        		}else {        			
        			result2.insert(index, chars[start]);
        			result2.insert(index, chars[end]);
        			index++;
        			start++;
        			end--;
        		}
        	}else {
        		result2.insert(index, chars[end]);
        		result2.insert(index, chars[end]);
        		index++;
        		end--;
        	}
        }
        
        return result.length() <= result2.length() ? result.toString() : result2.toString();
        
    }

}
