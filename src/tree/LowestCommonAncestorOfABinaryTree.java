package tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {
	/*
    find path for p and q
    the last common node is the lowest common ancestor
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // step1: find path
        List<TreeNode> pathP = new ArrayList<>();
        getPath(root, p, pathP);
        List<TreeNode> pathQ = new ArrayList<>();
        getPath(root, q, pathQ);
        
        // step2: find the last common node
        int i = 0;
        while (i < pathP.size() && i < pathQ.size()){
            if (pathP.get(i).val != pathQ.get(i).val){
                break;
            }
            i++;
        }
        return pathP.get(i - 1);
        
    }
    
    public boolean getPath(TreeNode root, TreeNode target, List<TreeNode> path){
        if (root == null){
            return false;
        }
        path.add(root);
        if (root.val == target.val){
            return true;
        }
        if (!getPath(root.left, target, path) && !getPath(root.right, target, path)){
            path.remove(path.size() - 1);
            return false;
        }
        return true;
        
    }
}
