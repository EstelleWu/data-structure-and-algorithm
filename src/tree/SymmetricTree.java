package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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
//	public boolean isSymmetric(TreeNode root) {
//        if (root == null){
//            return true;
//        }
//        return isSymmetricHelper(root.left, root.right);
//    }
//    
//    private boolean isSymmetricHelper(TreeNode node1, TreeNode node2){
//        if (node1 == null && node2 == null){
//            return true;
//        }
//        
//        if (node1 == null || node2 == null){
//            return false;
//        }
//        
//        if (node1.val != node2.val){
//            return false;
//        }
//        return isSymmetricHelper(node1.left, node2.right) && isSymmetricHelper(node1.right, node2.left);
//    }
	
	// bfs, iterative
	public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null){
                ;
            }else if (node1 == null || node2 == null){
                return false;
            }else{
                if (node1.val != node2.val){
                    return false;
                }
                queue.add(node1.left);
                queue.add(node2.right);
                queue.add(node1.right);
                queue.add(node2.left);
            }
        }
        return true;
    }
}
