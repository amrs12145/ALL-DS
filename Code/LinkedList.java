
public class LinkedList<E> {
	Node<E> head;
	
	public void append(E input) {
		if(head == null) {
			head = new Node<E>(input);
			return;
		}
		
		Node<E> current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node<E>(input); 
	}
	
	public void prepend(E input) {
		Node<E> newHead = new Node<E>(input);
		newHead.next = head;
		head = newHead;
	}
	
	public void deleteWithValue(E input) {
		if(head == null) return;
		if(head.input == input){
			head = head.next;
			return;
		}
		Node<E> current = head;
		
		while(current.next != null) {
			if(current.next.input == input) {
				 current.next = current.next.next;
				 return;
			}
			current = current.next; 
		}
		
	}
	public int size() {
		int size = 0;
		for(Node<E> n = head; n != null; n = n.next)
			size++;
		return size;
	}
	
	public E get(int index) {
		if(index >= size()) return null;
		Node<E> current = head;
		for(int i = 0; i < index; i++) 
			current = current.next;
		return current.input;
	}
	
	public void insert(E input, int index) {
		if(index >= size()) return;
		Node<E> current = head;
		for(int i = 0; i < index-1; i++) 
			current = current.next;
		Node<E> temp = current.next;
		current.next = new Node<E>(input);
		current.next.next = temp;
		
	}
	
		

}
