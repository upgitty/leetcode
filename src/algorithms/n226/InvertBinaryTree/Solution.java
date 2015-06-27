package algorithms.n226.InvertBinaryTree;

/**
 * @author upgitty
 *
 */
public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int x) {
			this.val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		
		//base case : return null for null
		if(root == null) {
			return null;
		}
		
		//Invert the left tree if exists
		TreeNode iLeft= null;
		if(root.left != null) {
			iLeft = invertTree(root.left);			
			
		}
		
		//Invert the right tree if exists
		TreeNode iRight = null;
		if(root.right != null) {
			iRight = invertTree(root.right);
			
		}
		
		//right is left and left is right
		root.right = iLeft;
		root.left = iRight;
		return root;
	}
	
}
