package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	static class Node{
        Node next;
        Node prev;
        int key;
        int val;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    // you can only declare and initialize var, not any other things
    private int capacity;
    private Map<Integer, Node> map = new HashMap();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (this.map.containsKey(key)){
            Node curr = this.map.get(key);
            addToFront(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value){
        Node curr = null;
        if (this.map.containsKey(key)){
            curr = this.map.get(key);
            curr.val = value;
        }else{
            if (this.capacity <= 0){
                removeLast();
                this.capacity++;
            }
            curr = new Node(key, value);
            this.capacity--;
            this.map.put(key, curr);
        }
        addToFront(curr);
    }
    
    private void addToFront(Node curr){
        Node prev = curr.prev;
        Node next = curr.next;
        
        // curr might be a newly created node
        if (prev != null && next != null){
            prev.next = next;
            next.prev = prev;
        }
        
        Node firstNode = this.head.next;
        this.head.next = curr;
        curr.prev = this.head;
        curr.next = firstNode;
        firstNode.prev = curr;
    }
    
    private void removeLast(){
        Node lastNode = this.tail.prev;
        Node newLastNode = lastNode.prev;
        newLastNode.next = this.tail;
        this.tail.prev = newLastNode;
        this.map.remove(lastNode.key);
    }
}
