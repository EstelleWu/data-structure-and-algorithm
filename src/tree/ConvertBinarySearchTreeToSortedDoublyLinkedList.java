package tree;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
	static class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	};
	public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }

        Node resFromLeft = treeToDoublyList(root.left);
        // root itself becomes a circular doubly-linked list, 
        // would never hit the base case
        // root.left = root;
        // root.right = root;
        Node resFromRight = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        Node res = contatenateTwoNodes(resFromLeft, root);
        Node res1 = contatenateTwoNodes(res, resFromRight);
        return res1;
    }


    private Node contatenateTwoNodes(Node node1, Node node2){
        if (node1 == null && node2 == null){
            return null;
        }
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }
        Node lastNodeFromNode1 = node1.left;
        Node lastNodeFromNode2 = node2.left;
        lastNodeFromNode1.right = node2;
        node2.left = lastNodeFromNode1;
        node1.left = lastNodeFromNode2;
        lastNodeFromNode2.right = node1;
        return node1;

    }

}
