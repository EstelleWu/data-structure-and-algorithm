package tree;


/*
approach1: count nodes
approach2: use the fact that this is a complete tree
height: h, go left until null node
if full binary tree -> math calculation
otherwise: recursion call on left subtree and right subtree
(left and right subtree are both complete tree)
*/
public class CountCompleteTreeNodes {
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
	
	public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int heightFromLeft = getHeightFromLeft(root);
        int heightFromRight = getHeightFromRight(root);
        // full binary tree
        if (heightFromLeft == heightFromRight){
            return (int)Math.pow(2, heightFromLeft) - 1;
        }else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    /*
    input: the node
    output: height from left subtree
    recursion relation: height of the root = height of the left subree + 1
    */
    private int getHeightFromLeft(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + getHeightFromLeft(root.left);
    }
    
    private int getHeightFromRight(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + getHeightFromRight(root.right);
    }
}
