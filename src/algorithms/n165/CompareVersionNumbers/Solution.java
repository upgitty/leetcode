/**
 * 
 */
package algorithms.n165.CompareVersionNumbers;

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
		System.out.println(solution.compareVersion("1.3", "1.4"));
	}

	/**
	 * Compares version numbers and tells which one bigger
	 * version1 > version2 : returns 1
	 * version1 > version2 : returns -1
	 * version1 = version2 : returns 0
	 * 
	 * @param version1 - string version 1
	 * @param version2 - string version 2
	 * @return as above
	 */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");	//split by DOT. Don't forget the escaping of . 
        String[] v2 = version2.split("\\.");	//split by DOT. Don't forget the escaping of .
        
        int min = Math.min(v1.length, v2.length);
        
        //Until min length you can compare versions together
        for(int i=0; i<min; i++) {
        	int vn1 = Integer.parseInt(v1[i]);
        	//Convert to integer
        	int vn2 = Integer.parseInt(v2[i]);
        	
        	if(vn1 != vn2) {
        		return vn1 > vn2 ? 1 : -1;
        	}
        }
        
        if(v1.length == v2.length) {
        	//If lengths are same and has reached until here: both are equal
        	return 0;
        }else if(v1.length > v2.length) {
        	//If v1 length is bigger, then check whether v1 has any more zeros or numbers greater than 0
        	for(int i=min; i<v1.length; i++) {
        		int vn1 = Integer.parseInt(v1[i]);
        		if(vn1 > 0) {
        			return 1;
        		}
        	}
        	return 0;
        }else {
        	//If v2 length is bigger, then check whether v2 has any more zeros or numbers greater than 0
        	for(int i=min; i<v2.length; i++) {
        		int vn2 = Integer.parseInt(v2[i]);
        		if(vn2 > 0) {
        			return -1;
        		}
        	}
        	return 0;
        }
    }
    
}
