package tree;

public class LowestCommonAncestorOfABinaryTree1 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root.val == p.val || root.val == q.val){
            return root;
        }
        
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        if (leftRes != null && rightRes != null){
            return root;
        }
        if (leftRes != null){
            return leftRes;
        }
        return rightRes;
    }
}
