package design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
bfs or dfs
dfs: 
inorder: no, the middle ele doesn't necessarily be the root
null, 2, null, 1, null, 4, null, 4, null, 5, null

preorder: the first ele is root, where does the boundary of the left and right subtree

1 2 null null 3 4 null null 5 null null
|
root left     right

1 null null 3 4 null null 5 null null
null null -> no left and right child for the current node;
             this current node is the left or right child of some other node -> move to right child / the tree is done

*/
public class SerializeAndDeserializeBinaryTree {
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	
	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder temp = new StringBuilder();
        serializeHelper(root, temp);
        return temp.toString().substring(0, temp.length() - 1);
    }
    
    // preorder
    // input (from caller to callee): node, string to append
    // output (from callee to caller): nothing?
    private static void serializeHelper(TreeNode root, StringBuilder res){
        if (root == null){
            res.append("null,");
            return;
        }
        res.append(Integer.toString(root.val));
        res.append(",");
        serializeHelper(root.left, res);
        serializeHelper(root.right, res);
    }

   // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        Queue<String> dataQueue = new LinkedList<>(Arrays.asList(dataArray));
        return deserializeHelper(dataQueue);
    }
    
    // preorder: first ele is the root
    // input (from caller to callee): data queue, data queue keep being modified
    // output (from callee to caller): tree node
    private static TreeNode deserializeHelper(Queue<String> dataQueue){
    	// use equals to compare Strings
        if (dataQueue.peek().equals("null")){
            dataQueue.poll();
            return null;
        }
        int val = Integer.parseInt(dataQueue.poll());
        TreeNode res = new TreeNode(val);
        res.left = deserializeHelper(dataQueue);
        res.right = deserializeHelper(dataQueue);
        return res;
    }
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		one.left = two;
		one.right = three;
		three.left = four;
		three.right = five;
		
		String data = serialize(one);
		TreeNode root = deserialize(data);
		System.out.println("a");
		

	}

}
