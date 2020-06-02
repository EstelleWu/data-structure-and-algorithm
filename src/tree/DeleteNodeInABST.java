package tree;

public class DeleteNodeInABST {
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
	/*
	 * when found the target node
	 * 1) leaf node, delete directly
     * 2) has one child, connect parent and this child
     * 3) has two children, choose one node from two subtree as the "root"
     */
	public static TreeNode deleteNode(TreeNode root, int key) {
    	if (root == null) {
    		return null;
    	}
        
        if (root.val == key){
            if (root.left == null && root.right == null) {
    			return null;
    		}else if (root.left != null && root.right == null) {
    			return root.left;
    		}else if (root.left == null && root.right != null) {
    			return root.right;
    		}else {
    			TreeNode minfromRight = findMin(root.right);
    			root.val = minfromRight.val;
    			root.right = deleteNode(root.right, minfromRight.val);
    		}
        }
        else if (root.val > key) {
    		root.left = deleteNode(root.left, key);
    	}else {
    		root.right = deleteNode(root.right, key);
    	}
    	return root;
    }
    
    
	private static TreeNode findMin(TreeNode node) {
		// TODO Auto-generated method stub
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode five = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode seven = new TreeNode(7);
		five.left = three;
		five.right = six;
		three.left = two;
		three.right = four;
		six.right = seven;
		
		TreeNode res = deleteNode(five, 3);
	}

}
