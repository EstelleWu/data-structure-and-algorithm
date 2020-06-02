package tree;

// recursion
public class InvertBinaryTree1 {
	public static class TreeNode {
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
	
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		
		TreeNode left = invertTree(root.right);
		TreeNode right = invertTree(root.left);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	node1.left = node2;
    	TreeNode res = invertTree(node1);
    	System.out.println("a");
	}

}
