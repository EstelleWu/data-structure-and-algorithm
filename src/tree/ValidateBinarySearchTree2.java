package tree;

import tree.ValidateBinarySearchTree1.TreeNode;

// post order traversal
public class ValidateBinarySearchTree2 {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
	// recursive
	public boolean isValidBST(TreeNode root) {
		  return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	    }
	    
    public boolean isValidBSTHelper(TreeNode node, long lower, long upper){
        if (node == null){
            return true;
        }
        if (!isValidBSTHelper(node.left, lower, node.val)){
            return false;
        }
        
        if (!isValidBSTHelper(node.right, node.val, upper)){
            return false;
        }
        
        return (node.val > lower && node.val < upper);
    }
}
