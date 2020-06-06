package design;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import design.SerializeAndDeserializeBinaryTree.TreeNode;

/*
should be as compact as possible -> no null in the string
bst

inorder: no, don't know where to start
preorder: left subtree, til the last ele smaller than the root

input (caller to callee): data, (upper / lower bound)
output (callee to caller): node
100 50 25 75 150 125 175
if less than parent val, left; else, right


recall: ValidateBinarySearchTree
*/



public class SerializeAndDeserializeBST {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder temp = new StringBuilder();
        serializeHelper(root, temp);
        if (temp.length() == 0){
            return temp.toString();
        }
        return temp.toString().substring(0, temp.length() - 1);
    }
    
    private static void serializeHelper(TreeNode root, StringBuilder res){
        if (root == null){
            return;
        }
        res.append(Integer.toString(root.val));
        res.append(",");
        serializeHelper(root.left, res);
        serializeHelper(root.right, res);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 0){
            return null;
        }
        String[] dataArray = data.split(",");
        Queue<String> dataQueue = new LinkedList<>(Arrays.asList(dataArray));
        return deserializeHelper(dataQueue, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    // input: lowerBound and upperBound to check if at valid position
    private static TreeNode deserializeHelper(Queue<String> dataQueue, long lowerBound, long upperBound){
    	if (dataQueue.size() == 0) {
    		return null;
    	}
    	int val = Integer.parseInt(dataQueue.peek());
    	if (val <= lowerBound || val >= upperBound) {
    		return null;
    	}
    	TreeNode res = new TreeNode(val);
    	dataQueue.poll();
    	res.left = deserializeHelper(dataQueue, lowerBound, res.val);
    	res.right = deserializeHelper(dataQueue, res.val, upperBound);
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "100,50,25,75,150,125,175";
		TreeNode res = deserialize(data);
		System.out.println("a");

	}

}
