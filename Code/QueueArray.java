
public class QueueArray {
	
	private int size;
	private int[] array;
	private int rear;
	private int front;
	
	public QueueArray(int size) {
		this.size = size;
		array = new int[size];
		front = -1;
		rear = -1;
	}
	
	public boolean isFull() {
		return (rear + 1)%size == front;

	}
	
	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}
	
	public boolean enqueue(int input) {
		if(isFull()) return false;
		else if(isEmpty()) {
			rear = 0;
			front = 0;
		}
		else {
			rear = (rear + 1) % size;
		}
		
		array[rear] = input;
		
		return true;
	}
	
	public int dequeue() {
		int lifo = -1;
		
		if(isEmpty()) return lifo;
		
		lifo = array[front];
		
		if(rear == front) {
			front = -1;
			rear = -1;
		}
		else {
		front = (front + 1) % size; 
		}
		return lifo;
	}
	
	public void display() {
		QueueArray temp = new QueueArray(size);
		int element;
		while(!isEmpty()) {
			element = dequeue();
			System.out.print(element + "  ");
			temp.enqueue(element);
		}
		System.out.println();
		while(!temp.isEmpty()) enqueue(temp.dequeue());
	}
	
	public int getSize() {
		int counter = 0;
		QueueArray temp = new QueueArray(size);
		while(!isEmpty()) {
			temp.enqueue(dequeue());
			counter ++;
		}
		while(!temp.isEmpty()) enqueue(temp.dequeue());
		return counter;
	}
	
	public boolean equals(QueueArray q) {
		boolean result = true;
		if(getSize() != q.getSize()) return false;
		QueueArray temp = new QueueArray(size*2);
		int value1 , value2;
		while(!isEmpty()) {
			value1 = dequeue();
			value2 = q.dequeue();
			temp.enqueue(value1);
			temp.enqueue(value2);
			if(value1 != value2) result = false;
			}
		while(!temp.isEmpty()) {
			enqueue(temp.dequeue());
			q.enqueue(temp.dequeue());
		}
		return result;
	}
	
	public boolean contains(int input) {
		boolean result = false;
		
		if(isEmpty()) return false;
		
		QueueArray temp = new QueueArray(size);
		int value;
		
		while(!isEmpty()) {
			value = dequeue();
			temp.enqueue(value);
			if(value == input) result = true;
			
		}
		while(!temp.isEmpty()) enqueue(temp.dequeue());
		
		return result;
	}
	
	public int getMin() {
	
		QueueArray temp = new QueueArray(size);
		int value;
		Integer min = null;
		
		while(!isEmpty()) {
			value = dequeue();
			temp.enqueue(value);
			if(min == null) min = value;
			else {
				if(min > value) min = value;
			}
			
		}
		
		while(!temp.isEmpty()) enqueue(temp.dequeue());
		return min;
	}
	
	public double getAverage() {
		double sum = 0;
		QueueArray temp = new QueueArray(size);
		while(!isEmpty()) {
			int element = dequeue();
			temp.enqueue(element);
			sum += element;
		}
		while(!temp.isEmpty()) enqueue(temp.dequeue());
		return sum / getSize();
	}
	

}
