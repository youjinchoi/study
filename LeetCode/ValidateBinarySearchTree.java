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
		return isValid(root.left, root.val) && isValid(root.right, root.val);
	}
	
	static boolean isValid(TreeNode node, int parentVal) {
		if (node == null) {
			return true;
		}
		
		if (node.left != null && node.left.val >= parentVal) {
			return false;
		}
		
		if (node.right != null && parentVal >= node.right.val) {
			return false;
		}
		
		return isValid(node.left, node.val) && isValid(node.right, node.val);
	}
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}