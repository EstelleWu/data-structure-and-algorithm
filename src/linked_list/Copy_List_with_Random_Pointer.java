package linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Copy_List_with_Random_Pointer {
//	class Node {
//	    int val;
//	    Node next;
//	    Node random;
//
//	    Node(int val) {
//	        this.val = val;
//	        this.next = null;
//	        this.random = null;
//	    }
//	}
	
	public static void helper(Node head){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
	
	
	public static Node copyRandomList(Node head) {
        // step1: copy each node, original_node -> copy_node
        Node temp = head;
        while (temp != null){
            // System.out.println(temp.val);
            Node new_node = new Node(temp.val);
            Node next_node = temp.next;
            temp.next = new_node;
            new_node.next = next_node;
            temp = next_node;
            // System.out.println(new_node.val);
            // System.out.println(temp.val);
            // System.out.println("aaa");
        }
        helper(head);
        // step2: random pointer
        Node temp1 = head;
        while (temp1 != null){
            Node copy_node = temp1.next;
            if (temp1.random != null){
                copy_node.random = temp1.random.next;
            }else{
                copy_node.random = null;
            }
            temp1 = temp1.next.next;
        }
        helper(head);
        // step3: separate 2 list
        Node temp2 = head;
        Node res = null;
        while (temp2 != null){
            Node copy_node = temp2.next;
            if (res == null){
                res = copy_node;
            }
            Node temp2_next = temp2.next.next;
            if (temp2_next != null){
                temp2.next = temp2_next;
                copy_node.next = temp2_next.next;
            }else{
                temp2.next = null;
            }
            temp2 = temp2_next;
        }
        return res;
    }
	
	
	public static void main(String[] args) {
//		Node n7 = new Node(7);
//		Node n13 = new Node(13);
//		Node n11 = new Node(11);
//		Node n10 = new Node(10);
//		Node n1 = new Node(1);
//		n7.next = n13;
//		n7.random = null;
//		n13.next = n11;
//		n13.random = n7;
//		n11.next = n10;
//		n11.random = n1;
//		n10.next = n1;
//		n10.random = n11;
//		n1.next = null;
//		n1.random = n7;
//		
//		
//		copyRandomList(n7);
	}


}
