/**
 * 
 */
package algorithms.n0010.RegularExpressionMatching;

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
		System.out.println(solution.isMatch("aa", "a.*"));
	}

	/**
	 * Credits : Program Creek solution
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
    public boolean isMatch(String s, String p) {
        //Base Case
    	if(p.length() == 0) {
    		return s.length() == 0;
    	}
    	
    	//Length of p is 1
    	if(p.length() == 1) {
    		
    		if(s.length() < 1) {
    			return false;
    		}
    		
    		//check the first char and if it does not match return false
    		if((p.charAt(0) != s.charAt(0)) && p.charAt(0) != '.') {
    			return false;
    		}
    		
    		//otherwise compare the rest of the string and p
    		else {
    			return isMatch(s.substring(1), p.substring(1));
    		}
    	}
    	
    	//when the second char at p is not a *
    	if(p.charAt(1) != '*') {
    		
    		if(s.length() < 1) {
    			return false;
    		}
    		
    		//check the first char and if it does not match return false
    		if((p.charAt(0) != s.charAt(0)) && p.charAt(0) != '.') {
    			return false;
    		}
    		
    		//otherwise compare the rest of the string and p
    		else {
    			return isMatch(s.substring(1), p.substring(1));
    		}
    	} else {
    		//when the second char at p is a *
    		
    		//something and * can be 0 
    		if(isMatch(s,p.substring(2))){
    			return true;
    		}
    		
    		int i = 0;
    		while(i<s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
    			if(isMatch(s.substring(i+1), p.substring(2))) {
    				return true;
    			}
    			i++;
    		}
    		
    		return false;
    	}
    	
    }
    
}
