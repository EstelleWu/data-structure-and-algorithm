package tree;

import java.util.ArrayDeque;
import java.util.Deque;

import tree.RecoverBinarySearchTree.TreeNode;

// preorder traversal
public class ValidateBinarySearchTree {
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
	
// RECURSIVE	
//    public boolean isValidBST(TreeNode root) {
//        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//	private boolean isValidBSTHelper(TreeNode root, long lowerBound, long upperBound) {
//		if (root == null) {
//			return true;
//		}
//		if (root.val <= lowerBound || root.val >= upperBound) {
//			return false;
//		}
//		return isValidBSTHelper(root.left, lowerBound, root.val) && isValidBSTHelper(root.right, root.val, upperBound);
//	}
	
	// ITERATIVE
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
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return false;
		}
		Deque<Entry> stack = new ArrayDeque<>();
		stack.addLast(new Entry(root, Long.MIN_VALUE, Long.MAX_VALUE));
		while (stack.size() > 0) {
			Entry curEntry = stack.pollLast();
			if (curEntry.node.val <= curEntry.lower || curEntry.node.val >= curEntry.upper) {
				return false;
			}
			if (curEntry.node.left != null) {
				stack.addLast(new Entry(curEntry.node.left, curEntry.lower, curEntry.node.val));
			}
			if (curEntry.node.right != null) {
				stack.addLast(new Entry(curEntry.node.right, curEntry.node.val, curEntry.upper));
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
