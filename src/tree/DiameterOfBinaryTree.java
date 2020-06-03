package tree;

public class DiameterOfBinaryTree {
	// currentResult = leftChildResult + rightChildResult + 1
    // recursion relation: currentLength = max(lengthFromLeft, lengthFromRight) + 1
    static int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
    	DiameterOfBinaryTree.res = 0;
        if (root == null){
            return 0;
        }
        diameterOfBinaryTreeHelper(root);
        return DiameterOfBinaryTree.res - 1;
    }
    
    public int diameterOfBinaryTreeHelper(TreeNode root){
        if (root == null){
            return 0;
        }
        int lengthFromLeft = diameterOfBinaryTreeHelper(root.left);
        int lengthFromRight = diameterOfBinaryTreeHelper(root.right);
        int currentDiameter = lengthFromLeft + lengthFromRight + 1;
        DiameterOfBinaryTree.res = Math.max(DiameterOfBinaryTree.res, currentDiameter);
        return Math.max(lengthFromLeft, lengthFromRight) + 1;
                         
    }
}
