
public class LinkedStack {
	
	Node<Integer> top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		return top.input;
	}
	
	public void push(int input) {
		Node<Integer> n = new Node(input);
		n.next = top;
		top = n;
	}
	
	public int pop() {
		int value = top.input;
		top = top.next;
		return value;
	}

}
