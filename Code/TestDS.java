
public class TestDS {

	public static void main(String[] args) {
		Heap h = new Heap();
		h.insert(3);
		h.insert(8);
		h.insert(4);
		h.insert(13);
		h.insert(23);
		h.insert(12);
		h.insert(24);
		h.insert(43);
		h.insert(38);
		h.insert(2);
		h.insert(10);
		h.insert(15);
		h.insert(20);
		h.insert(17);
		h.insert(14);
		//System.out.println(h.peek());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		
	}
	public static void swap(int[] items, int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
}
