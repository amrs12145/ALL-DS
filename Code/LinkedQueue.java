
public class LinkedQueue {
	Node<Integer> front;
	Node<Integer> rear;
	
	public LinkedQueue() {
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return front == null && rear == null;
		
	}
	
	public void enqueue(int input) {
		Node<Integer> n = new Node(input);
		if(isEmpty()) {
			front = rear = n;
		}
		else {
			rear.next = n;
			rear = n;
		}
	}
		public int dequeue() {
			int value = front.input;
			if(front == null) rear = null;
			front = front.next;
			return value;
	}

}
