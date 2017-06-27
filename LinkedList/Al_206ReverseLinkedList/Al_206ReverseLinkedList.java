package LinkedList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Al_206ReverseLinkedList {

	/* iterative solution */
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
	
	/* recursive solution */
	public ListNode reverseList_recur(ListNode head) {
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null)
	        return newHead;
	    ListNode next = head.next;
	    head.next = newHead;
	    return reverseListInt(next, head);
	}
	
	/* recursive solution 2*/
	public ListNode head = null;
	public ListNode reverseList_recur2(ListNode current) {
		if (current == null) {
			return null;
		}
		if (current.next == null) {
			head = current;
			return null;
		}
		reverseList_recur2(current.next);
		current.next.next = current;
		current.next = null;
		return head;
	}
	
	public void display(ListNode head){
		//
		ListNode currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.val);
			currNode=currNode.next;
		}
	}
	public static void main(String[] args){
		Al_206ReverseLinkedList solution = new Al_206ReverseLinkedList();
		ListNode lnode = new ListNode(10);
		lnode.next = new ListNode(8);;
		lnode.next.next = new ListNode(6);;
		lnode.next.next.next = new ListNode(4);
		lnode.next.next.next.next = new ListNode(2);
		ListNode output = new ListNode(0);
		output = solution.reverseList(lnode);
		System.out.println("--->Iterative way:");
		solution.display(output);
		System.out.println("\n--->Recursive way:");
		output = solution.reverseList_recur(output);
		solution.display(output);
		System.out.println("\n--->Recursive way 2:");
		output = solution.reverseList_recur2(output);
		solution.display(output);
		
	}
}
