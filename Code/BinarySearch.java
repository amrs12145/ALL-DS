
public class BinarySearch {

	public static void main(String[] args) {
		int[] list = {1,3,5,7,9,11,13,15,17,19};
		System.out.print(recurBinarySearch(list, 19));

	}
	
	public static int binarySearch(int[] list, int key) {
		int i = 0;
		int n = list.length - 1;
		while(true) {
			int mid = (n + i) / 2;
			if(key == list[mid]) return mid;
			if(key > list[mid]) i = mid + 1;
			else n = mid - 1;
		}
	}
	
	public static int recurBinarySearch(int[] list, int i, int n, int key) {
		int mid = (i + n) / 2;
		if(key == list[mid]) return mid;
		if(key > list[mid]) return recurBinarySearch(list, mid + 1, n ,key);
		else return recurBinarySearch(list, i, mid - 1, key);
	}
	
	public static int recurBinarySearch(int[] list, int key) {
		return recurBinarySearch(list, 0, list.length - 1, key);
	}
}
