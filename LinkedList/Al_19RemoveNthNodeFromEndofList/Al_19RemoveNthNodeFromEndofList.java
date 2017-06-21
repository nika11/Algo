package LinkedList;

public class Al_19RemoveNthNodeFromEndofList {
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    
	    ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
	public static void main(String[] args){
		Al_19RemoveNthNodeFromEndofList removeNode = new Al_19RemoveNthNodeFromEndofList();
		Al_19RemoveNthNodeFromEndofList.ListNode l1 = removeNode.new ListNode(1);
		Al_19RemoveNthNodeFromEndofList.ListNode l2 = removeNode.new ListNode(2);
		Al_19RemoveNthNodeFromEndofList.ListNode l3 = removeNode.new ListNode(3);
		Al_19RemoveNthNodeFromEndofList.ListNode l4 = removeNode.new ListNode(4);
		Al_19RemoveNthNodeFromEndofList.ListNode l5 = removeNode.new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		Al_19RemoveNthNodeFromEndofList.ListNode l_return = removeNode.removeNthFromEnd(l1, 2);
		for(Al_19RemoveNthNodeFromEndofList.ListNode li = l_return;li != null; li = li.next){
			System.out.println(li.val);
			
		}
	}
}
