package tree;

import java.util.Stack;

import tree.InsertIntoABinarySearchTree.TreeNode;

public class RecoverBinarySearchTree {
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
	public void recoverTree(TreeNode root) {
        TreeNode prevNode = null;
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        
        // step1: use in order traversal to find the two nodes
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || node != null) {
        	while (node != null) {
        		stack.push(node);
        		node = node.left;
        	}
        	TreeNode curNode = stack.pop();
        	if (prevNode != null && curNode.val <= prevNode.val) {
        		if (firstNode == null) {
        			firstNode = prevNode;
        		}else {
        			secondNode = curNode;
        		}
        	}
        	prevNode = curNode;
        	if (curNode.right != null) {
        		node = curNode.right;
        	}
        }
        
        // step2: can swap the values directly
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
