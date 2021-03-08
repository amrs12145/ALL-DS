import java.util.*;
public class StackMethods {

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		Stack<String> f = new Stack<String>();
		s.push("world");
		s.push("Hi");
		f.push("Hi");
		f.push("world");
		//System.out.println(contains(s,7.0));
		System.out.println(isReverse(s,f));

	}
	public static int size(Stack s) {
		int size = 0;
		Stack temp = new Stack();
		while(!s.isEmpty()) {
			size++;
			temp.push(s.pop());
			
		}
		while(!temp.isEmpty())
			s.push(temp.pop());
		return size;
	}
	
	public static void getMaxAndMin(Stack<Double> s) {
		Double max = null , min = null;
		Stack<Double> temp = new Stack<Double>();
		while(!s.isEmpty()) {
			if(max == null && min == null) {
				max = s.peek();
				min = s.peek();
			}
			else {
				if(max < s.peek()) max = s.peek();
				if(min > s.peek()) min = s.peek();
			temp.push(s.pop());
			}
		}
		while(!temp.isEmpty())
			s.push(temp.pop());
		System.out.println("Max value : " + max + " ,Min value : " + min);
		
	}
	
	public static Double getAverage(Stack<Double> s) {
		double sum = 0;
		Stack<Double> temp = new Stack<Double>();
		while(!s.isEmpty()) {
			sum += s.peek();
			temp.push(s.pop());
			
		}
		while(!temp.isEmpty())
			s.push(temp.pop());
		return sum / size(s);
	}
	
	public static boolean contains(Stack<Double> s , double value) {
		Stack<Double> temp = new Stack<Double>();
		boolean result = false;
		while(!s.isEmpty()) {
			if(value == s.peek()) result = true;
			temp.push(s.pop());
			
		}
		while(!temp.isEmpty())
			s.push(temp.pop());
		return result;
	}
	
	public static boolean equals(Stack s1 ,Stack s2) {
		if(size(s1) != size(s2)) return false;
		boolean equal = true;
		Stack temp = new Stack();
		while(!s1.isEmpty() && !s2.isEmpty()) {
			if(s1.peek() != s2.peek()) equal = false;
			temp.push(s1.pop());
			temp.push(s2.pop());
		}
		while(!temp.isEmpty()) {
			s1.push(temp.pop());
			s2.push(temp.pop());
		}
		return equal;
	}
	
	public static boolean isReverse(Stack s1 , Stack s2) {
		boolean isReverse = false;
		Stack temp = new Stack();
		while(!s1.isEmpty()) {
			temp.push(s1.pop());
		}
		if(equals(s2,temp)) isReverse = true;
		
		while(!temp.isEmpty())
			s1.push(temp.pop());
		return isReverse;
	}

}
