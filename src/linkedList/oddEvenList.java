package linkedList;

public class oddEvenList {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public static ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        // step1: divide into two linked list
        ListNode temp1 = new ListNode();
        ListNode temp1Copy0 = temp1;
        ListNode temp2 = new ListNode();
        ListNode temp2Copy0 = temp2;
        ListNode temp = head;
        int count = 1;
        while (temp != null){
            if (count %2 == 1){
                temp1Copy0.next = temp;
                temp1Copy0 = temp1Copy0.next;
            }else{
                temp2Copy0.next = temp;
                temp2Copy0 = temp2Copy0.next;
            }
            temp = temp.next;
            count++;
        }
        temp1Copy0.next = null;
        temp2Copy0.next = null;
        // step2: append
        temp1Copy0.next = temp2.next;
        return temp1.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		ListNode res = oddEvenList(one);
	}

}
