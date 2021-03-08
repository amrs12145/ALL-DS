 
public class StackArray<E> {
	private E[] arr;
	private int top;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public StackArray() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public StackArray(int ArraySize) {
		integrityOK = false;
		arr = (E[])new Object[ArraySize];
		top = -1;
	}
	
	public boolean push(E input) {
		if(!IsFull()) {
			arr[++top] = input;
		return true;
		}
		else return false;
		
	}
	
	public E pop() { 
		if(IsEmpty()) return arr[--top];
		else return null;
	}
	
	public boolean IsEmpty() {
		return top == -1;
	}
	public boolean IsFull() {
		return top == arr.length-1;
	}
	
	public E peek() {
		return arr[top];
	}
	
	public void printStack() {
		StackArray<E> temp = new StackArray<E>(arr.length);
		while(!IsEmpty()) {
			System.out.println(arr[top] + " ");
			temp.push(pop());
		}
		System.out.println();
		while(!temp.IsEmpty())
		push(temp.pop());
	}
	

}
