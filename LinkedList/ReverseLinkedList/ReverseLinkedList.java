ListNode currNode = head;


while(currNode != null){
  nextNode = currNode.next;
  currNode.next = prevNode;
  prevNode = currNode;
  currNode = nextNode;
}
