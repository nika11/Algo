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
public class Al_445AddTwoNumbersII {
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }
	public static void main(String[] args){
		Al_445AddTwoNumbersII addTwoNumber = new Al_445AddTwoNumbersII();
		Al_445AddTwoNumbersII.ListNode l10 = addTwoNumber.new ListNode(7);
		Al_445AddTwoNumbersII.ListNode l20 = addTwoNumber.new ListNode(2);
		l10.next = l20;
		Al_445AddTwoNumbersII.ListNode l30 = addTwoNumber.new ListNode(4);
		l20.next = l30;
		Al_445AddTwoNumbersII.ListNode l40 = addTwoNumber.new ListNode(3);
		l30.next = l40;
		Al_445AddTwoNumbersII.ListNode l11 = addTwoNumber.new ListNode(5);
		Al_445AddTwoNumbersII.ListNode l21 = addTwoNumber.new ListNode(6);
		l11.next = l21;
		Al_445AddTwoNumbersII.ListNode l31 = addTwoNumber.new ListNode(4);
		l21.next = l31;
		Al_445AddTwoNumbersII.ListNode output = addTwoNumber.addTwoNumbers(l10, l11);
		for(Al_445AddTwoNumbersII.ListNode l=output;l!=null;l = l.next){
			System.out.println(l.val);
		}
		
	}
}
