package tree;

import java.util.ArrayList;
import java.util.List;

import tree.RecoverBinarySearchTree.TreeNode;
/*
 * Question: All nodes along children pointers from root to leaf nodes form a path 
 * in a binary tree. Given a binary tree and a number, please print out all of paths
 * where the sum of all nodes value is same as the given number.
 * */

/*
 * backtracking, getPath
 * */
public class PathsWithSpecifiedSumInBinaryTree {
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
		List<TreeNode> path;
		int sum;
		Entry(List<TreeNode> path, int sum){
			this.path = path;
			this.sum = sum;
		}
	}
	
	public static List<List<TreeNode>> solve(TreeNode root, int expectedSum){
		if (root == null) {
			return null;
		}
		List<List<TreeNode>> res = new ArrayList<>();
		List<TreeNode> currentPath = new ArrayList<>();
		int currentSum = 0;
		Entry pathAndSum = new Entry(currentPath, currentSum);
		backtracking(root, pathAndSum, expectedSum, res);
		return res;
	}
	
	// sum is a var passed between caller and callee
	// sum is a primitive type
	// method1: data member
	// method2: wrap it to a object
	
	private static void backtracking(TreeNode root, Entry pathAndSum, int expectedSum, List<List<TreeNode>> res) {
		pathAndSum.path.add(root);
		pathAndSum.sum += root.val;
		
		// base case, leaf node
		if (root.left == null && root.right == null) {
			if (pathAndSum.sum == expectedSum) {
				// return a copy, otherwise would be changed
				// see word ladder 2
				List<TreeNode> path = new ArrayList<>(pathAndSum.path);
				res.add(path);
			}
			pathAndSum.path.remove(pathAndSum.path.size() - 1);
			pathAndSum.sum -= root.val;
			return;
		}
		
		
		if (root.left != null) {
			backtracking(root.left, pathAndSum, expectedSum, res);
		}
		if (root.right != null) {
			backtracking(root.right, pathAndSum, expectedSum, res);
		}
		pathAndSum.path.remove(pathAndSum.path.size() - 1);
		pathAndSum.sum -= root.val;
		return;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode ten = new TreeNode(10);
		TreeNode five = new TreeNode(5);
		TreeNode twelve = new TreeNode(12);
		TreeNode four = new TreeNode(4);
		TreeNode seven = new TreeNode(7);
		ten.left = five;
		ten.right = twelve;
		five.left = four;
		five.right = seven;
		List<List<TreeNode>> res = solve(ten, 22);
		System.out.println(1);

	}

}
