/**
 * 
 */
package algorithms.n150.EvaluateReversePolishNotation;

import java.util.Stack;

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
		String[] tokens = {"2", "1", "+", "3", "*"};
		System.out.println(solution.evalRPN(tokens));
	}

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String token: tokens) {
        	int a = -1;
        	int b = -1;
        	switch(token) {
        		case "*" : 
        			a = Integer.valueOf(stack.pop());
        			b = Integer.valueOf(stack.pop());
        			stack.push(String.valueOf(b * a));
        			break;
        		case "/" : 
        			a = Integer.valueOf(stack.pop());
        			b = Integer.valueOf(stack.pop());
        			stack.push(String.valueOf(b / a));
        			break;
        		case "+" : 
        			a = Integer.valueOf(stack.pop());
        			b = Integer.valueOf(stack.pop());
        			stack.push(String.valueOf(b + a));
        			break;
        		case "-" : 
        			a = Integer.valueOf(stack.pop());
        			b = Integer.valueOf(stack.pop());
        			stack.push(String.valueOf(b - a));
        			break;
        		default : 
        			stack.push(token);
        	}
        }
        
        return Integer.valueOf(stack.pop());
    }
    
}
