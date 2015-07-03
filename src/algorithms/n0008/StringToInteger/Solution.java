/**
 * 
 */
package algorithms.n0008.StringToInteger;

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
		System.out.println(solution.myAtoi("  -0012a42"));
	}

    public int myAtoi(String str) {
        
    	//Handle null and empty string
    	if(str == null || str.isEmpty()) {
        	return 0;
        }
        
    	//handle white spaces
    	str = str.trim();
    	
    	//check sign and mark starting index of numbers
    	boolean isPositive = true;
    	int index = 0;
    	if(str.charAt(0) == '-') {
    		isPositive = false;
    		index++;
    	}else if(str.charAt(0) == '+') {
    		index++;
    	}
    	
    	//result is stored in a double to handle out of bound values
    	double result = 0;
    	
    	while(index < str.length()) {
    		char ch = str.charAt(index);
    		if(ch >= '0' && ch <= '9') {    			
    			result = result * 10 + (ch - '0');
    			index++;
    		}else {
    			break;
    		}
    	}
    	
    	if(!isPositive){
    		result = -result;
    	}
    	
    	if(result > Integer.MAX_VALUE) {
    		return Integer.MAX_VALUE;
    	}
    	
    	if(result < Integer.MIN_VALUE) {
    		return Integer.MIN_VALUE;
    	}
    	
    	return (int) result;
    }
}
