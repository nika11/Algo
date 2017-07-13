MyLinkedList<String> list = new MyLinkedList<String>();
list.deleteLast();
public ListNode<E> deleteLast(){
  if(head != null)
  {
    current = head;
    while(current.getNext()!=null)
    {
      previous = current;
      current = current.getNext();
    }
    previous.setNext(null);
    return current;
  }
  return null;
}
