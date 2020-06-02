package tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

public class CousinsInBinaryTree {
	// dfs, return value: if the current path is the target path (contains x)
	public static boolean getPath(TreeNode root, int x, List<Integer> res){
        if (root == null){
            return false;
        }
        if (root.val == x){
            res.add(root.val);
            return true;
        }
        if (getPath(root.left, x, res) || getPath(root.right, x, res)){
            res.add(root.val);
            return true;
        }else{
            return false;
        }      
    }
    
    public static boolean isCousins(TreeNode root, int x, int y) {
        List<Integer> pathX = new ArrayList<>();
        getPath(root, x, pathX);
        List<Integer> pathY = new ArrayList<>();
        getPath(root, y, pathY);
        if (pathX.size() != pathY.size()){
            return false;
        }
        return (pathX.get(1) != pathY.get(1));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		one.left = two;
		one.right = three;
		two.right = four;
		boolean res = isCousins(one, 2, 3);
		System.out.println(res);
	}

}
