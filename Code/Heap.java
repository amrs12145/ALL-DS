import java.util.Arrays;

public class Heap {
	private int capacity = 10;
	private int size = 0;
	
	int[] items = new int[capacity];
	
	private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
	private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
	private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }
	
	private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
	private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
	private boolean hasParent(int index) { return getParentIndex(index) < size; }
	
	private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
	private int rightChild(int index) { return items[getRightChildIndex(index)]; }
	private int parent(int index) { return items[getParentIndex(index)]; }
	
	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
	
	private void ensureExtraCapacity() {
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	public int peek() {
		if(size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	public int extractMin() {
		if(size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void insert(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	private void heapifyUp() {
		int index = size - 1;
		while(hasParent(index) && parent(index) > items[index]) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}
	
	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerIndex = getLeftChildIndex(index);
			 if(hasRightChild(index) && leftChild(index) > rightChild(index)) {
				 smallerIndex = getRightChildIndex(index);
			 }
			 if(items[smallerIndex] > items[index]) break;
			 else swap(smallerIndex, index);
			 
			 index = smallerIndex;
		}
	}
	
	public void print() {
		for(int i = 0; i < size; i++) System.out.print(items[i] + " ");
	}
}
