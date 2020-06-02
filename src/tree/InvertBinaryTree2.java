package tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.InvertBinaryTree1.TreeNode;

// iteration + bfs
public class InvertBinaryTree2 {
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
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            // don't have to be level by level
            // choose to do it for visulization reason
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                TreeNode leftChildOfCur = cur.left;
                cur.left = cur.right;
                cur.right = leftChildOfCur;
                
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }
}
