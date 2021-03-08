
public class SelectionSort {

	public static void main(String[] args) {
		int[] list = { 5, 10,8,3,5,3,5,12,7,8,9,4};
		recurSelectionSort(list, list.length, 0);
		for(int i = 0; i < list.length; i++) 
			System.out.print(list[i] + " ");
		System.out.println();
		System.out.println(minIndex(list, list.length, 0 ));
	}
	
	public static void selectionSort(int[] list) {
		int minValue;
		
		//one by one traverse
		for(int i = 0; i < list.length; i++) {
			
			//searching for the minimum value;
			minValue = i;
			for(int j = i; j < list.length; j++) {
				if(list[minValue] > list[j]) minValue = j;
			}
			
			//swap the minimum value with the i-th place in list 
			int temp = list[minValue];
			list[minValue] = list[i];
			list[i] = temp;
		}		
	}
	
	public static void recurSelectionSort(int[] list, int n, int i) {
		if(i == n) return;
		
		
		
		int minIndex = minIndex(list, n, i);
		
		if(minIndex != i) {
			int temp = list[minIndex];
			list[minIndex] = list[i];
			list[i] = temp;
		}
		
		recurSelectionSort(list, n, i + 1);
	}
	
	public static int minIndex(int[] list ,int n) {
		if(n == 0) return 0;
			
			int min = minIndex(list, n - 1);
			
			return (list[min] < list[n - 1])? min : n - 1;
	}
	
	public static int minIndex(int[] list, int n, int i) {
		if(i == n-1) return i;
		
		int min = minIndex(list, n, i+1);

		return (list[min] < list[i])? min : i;
	}

}
