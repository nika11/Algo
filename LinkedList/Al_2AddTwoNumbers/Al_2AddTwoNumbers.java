package LinkedList;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Al_2AddTwoNumbers {
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
	public static void main(String[] args){
		Al_2AddTwoNumbers addTwoNumber = new Al_2AddTwoNumbers();
		Al_2AddTwoNumbers.ListNode l10 = addTwoNumber.new ListNode(7);
		Al_2AddTwoNumbers.ListNode l20 = addTwoNumber.new ListNode(2);
		l10.next = l20;
		Al_2AddTwoNumbers.ListNode l30 = addTwoNumber.new ListNode(4);
		l20.next = l30;
		Al_2AddTwoNumbers.ListNode l40 = addTwoNumber.new ListNode(3);
		l30.next = l40;
		Al_2AddTwoNumbers.ListNode l11 = addTwoNumber.new ListNode(5);
		Al_2AddTwoNumbers.ListNode l21 = addTwoNumber.new ListNode(6);
		l11.next = l21;
		Al_2AddTwoNumbers.ListNode l31 = addTwoNumber.new ListNode(4);
		l21.next = l31;
		Al_2AddTwoNumbers.ListNode output = addTwoNumber.addTwoNumbers(l10, l11);
		for(Al_2AddTwoNumbers.ListNode l=output;l!=null;l = l.next){
			System.out.println(l.val);
		}
		
	}
}
