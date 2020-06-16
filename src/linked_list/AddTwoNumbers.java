package linked_list;

import java.util.Stack;

public class AddTwoNumbers {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s = new Stack<>();
        int carry = 0;
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while (l1 != null || l2 != null || carry != 0){
            int sum = 0;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        return res.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode two = new ListNode(2);
		ListNode four = new ListNode(4);
		ListNode three = new ListNode(3);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode four1 = new ListNode(4);
		two.next = four;
		four.next = three;
		five.next = six;
		six.next = four1;
		ListNode res = addTwoNumbers(two, five);
		System.out.println(1);
//		[2,4,3]
//				[5,6,4]
						

	}

}
