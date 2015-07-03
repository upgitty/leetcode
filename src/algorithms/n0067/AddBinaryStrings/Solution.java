/**
 * 
 */
package algorithms.n0067.AddBinaryStrings;

/**
 * @author upgitty
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.addBinary("110110", "001011"));
	}
	
	public String addBinary(String a, String b) {
		
		//Null strings return null because we cannot add them
		if(a == null || b == null) {
			return null;
		}
		
		//We create pointers to end of strings and move backwards;
		int aPt = a.length() - 1;
		int bPt = b.length() - 1;
		
		//init sum and carry to 0
		int carry = 0;
		int sum = 0;
		StringBuilder result = new StringBuilder();
		
		//While both indexes are greater than zero, we can common bits we can add.
		while(aPt >= 0 && bPt >= 0) {
			int op1 = a.charAt(aPt) - '0';	//get int value
			int op2 = b.charAt(bPt) - '0';	//get int value
			sum = op1 ^ op2 ^ carry;		//Sum is XOR of all three
			carry = (carry & op1) | (carry & op2) | (op1 & op2);	//Carry is AND of any 2
			result.append(sum);				//We insert as end as we will reverse the string in the end
			aPt--; bPt--;					//Decrement both indices together
		}
		
		//Now if a has anything left, we add that to result (Don't forget the carry here)
		while(aPt >= 0) {
			int op1 = a.charAt(aPt) - '0';
			sum = op1 ^ carry;
			carry = carry & op1;
			result.append(sum);
			aPt--;
		}
		
		//Now if b has anything left, we add that to result (Don't forget the carry here)
		while(bPt >= 0) {
			int op2 = b.charAt(bPt) - '0';
			sum = op2 ^ carry;
			carry = carry & op2;
			result.append(sum);
			bPt--;
		}
		
		//If anything is left in the carry, we will add that to the result
		if(carry > 0) {
			result.append(carry);
		}
		
		//Reverse the result and return
		return result.reverse().toString();
	}
	
}
