/**
 * 
 */
package algorithms.n0205.IsomorphicStrings;

import java.util.HashMap;
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
		System.out.println(solution.isIsomorphic("eggs", "addd"));
	}

	/**
	 * 
	 * Time complexity : O(n)
	 * @param s
	 * @param t
	 * @return
	 */
    public boolean isIsomorphic(String s, String t) {
        
    	if((s == null && t != null) || (s != null && t == null)) {
    		return false;
    	}
    	
    	if(s.length() != t.length()) {
    		return false;
    	}
    	
    	if(s.isEmpty()) {
    		return true;
    	}
    	
    	Map<Character, Character> srcToDst = new HashMap<>();
        Map<Character, Character> dstToSrc = new HashMap<>();
        
        char[] source = s.toCharArray();	//O(n)
        char[] dest = t.toCharArray();		//O(n);
        int index = 0;		
        int len = source.length;
        
        //O(n)
        while(index < len) {
        	if(srcToDst.containsKey(source[index])) {
        		//Means we have seen the source char before
        		Character seen = srcToDst.get(source[index]);
        		if(seen != dest[index]) {
        			//Not ok since its used for something else
        			return false;
        		}
        		srcToDst.put(source[index], dest[index]);
        		dstToSrc.put(dest[index], source[index]);
        		dest[index] = source[index];
        		index++;
        	}else {
        		//Means we have not seen this character before
        		if(dstToSrc.containsKey(dest[index])) {
        			//Means we have seen the dest char before
        			Character seen = dstToSrc.get(dest[index]);
        			if(seen != source[index]) {
        				//Not ok since we have replaced this dest char with something else before
        				return false;
        			}
        			
        			srcToDst.put(source[index], dest[index]);
            		dstToSrc.put(dest[index], source[index]);
            		dest[index] = source[index];
        			index++;
        		}else {
        			srcToDst.put(source[index], dest[index]);
            		dstToSrc.put(dest[index], source[index]);
            		dest[index] = source[index];
        			index++;
        		}
        		
        	}
        }
        
        //O(n)
        int i = 0;
        while(i < source.length) {
        	if(source[i] != dest[i]) {
        		return false;
        	}
        	i++;
        }
        
        return true;
    }
    
}
