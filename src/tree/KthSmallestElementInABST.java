package tree;

import java.util.Stack;

public class KthSmallestElementInABST {
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
	
	// in order traversal, left - cur - right, stack
    public int kthSmallest(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (stack.size() > 0 || node != null) {
        	 while (node != null) {
             	stack.push(node);
             	node = node.left;
             }
             TreeNode curNode = stack.pop();
             if (count == k) {
             	return curNode.val;
             }
             if (curNode.right != null) {
             	node = curNode.right;
             }
             count++;
        }
        return -1;
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
