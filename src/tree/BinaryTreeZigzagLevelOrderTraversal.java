package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import tree.ValidateBinarySearchTree1.TreeNode;

/*
1
2        3
4   5    6   7
8 9 10 11    13 14  

1

read                [1]
insert from right, left child and then right child 
2 3 

read from right     [3 2]                             pollLast
insert from left, right child and then left child     addFirst
4 5 6 7 

read from left [4, 5, 6, 7]                           pollFirst    !!
insert from right, left child and then right child    addLast
14 13 11 10 9 8

read from right [14 13 11 10 9 8]


*/

public class BinaryTreeZigzagLevelOrderTraversal {
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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        boolean pollFirstAddLast = true;
        while (deque.size() > 0){
            int size = deque.size();
            List<Integer> curRes = new ArrayList<>();
            for (int i = 0; i < size; i++){
                if (pollFirstAddLast){
                    TreeNode cur = deque.pollFirst();
                    curRes.add(cur.val);
                    if (cur.left != null){
                        deque.addLast(cur.left);
                    }
                    if (cur.right != null){
                        deque.addLast(cur.right);
                    }
                }else{
                    TreeNode cur = deque.pollLast();
                    curRes.add(cur.val);
                    if (cur.right != null){
                        deque.addFirst(cur.right);
                    }
                    if (cur.left != null){
                        deque.addFirst(cur.left);
                    }
                }
                
            }
            res.add(curRes);
            pollFirstAddLast = !pollFirstAddLast;
        }
        return res;
    }

}
