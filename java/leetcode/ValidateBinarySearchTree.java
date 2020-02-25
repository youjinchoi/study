package leetcode;
/*
* https://leetcode.com/problems/validate-binary-search-tree/
* 
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
* 
* */
public class ValidateBinarySearchTree {
	static boolean isValidBST(TreeNode root) {
		return isValid(root);
	}
	
	static boolean isValid(TreeNode node) {
		if (node == null) {
			return true;
		}
		
		if (node.left != null && node.left.val >= node.val) {
			return false;
		}
		
		if (node.right != null && node.val >= node.right.val) {
			return false;
		}
		
		return isValid(node.left) && isValid(node.right);
	}
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}