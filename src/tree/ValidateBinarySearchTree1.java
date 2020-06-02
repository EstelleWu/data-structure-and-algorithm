package tree;

import java.util.ArrayDeque;
import java.util.Deque;

import tree.ValidateBinarySearchTree.TreeNode;

// inorder traversal
public class ValidateBinarySearchTree1 {
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
	static class Entry{
		TreeNode node;
		long lower;
		long upper;
		Entry(TreeNode node, long lower, long upper){
			this.node = node;
			this.lower = lower;
			this.upper = upper;
		}
	}
	

  // ITERATIVE
  // ensure the current one is bigger than the previous one	
//	public boolean isValidBST(TreeNode root) {
//		  if (root == null) {
//			  return true;
//		  }
//		  
//		  Deque<TreeNode> stack = new ArrayDeque<>();
//		  TreeNode node = root;
//		  long prevVal = Long.MIN_VALUE;
//		  
//		  while (stack.size() > 0 || node != null) {
//			  while (node != null) {
//				  stack.addLast(node);
//				  node = node.left;
//			  }
//	          TreeNode curNode = stack.pollLast();
//			  if (curNode.val <= prevVal) {
//				  return false;
//			  }else {
//				  prevVal = curNode.val;
//			  }
//			  if (curNode.right != null) {
//				  node = curNode.right;
//			  }
//		  }
//		  return true;
//	  }
	
	// RECURSIVE
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
        if (node.val <= lower || node.val >= upper){
            return false;
        }
        return isValidBSTHelper(node.right, node.val, upper);
    }
	    
	    
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
