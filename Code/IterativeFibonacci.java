
public class IterativeFibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacci(45));

	}
	
	public static int fibonacci(int n) {
		int Xn1 = 0;
		int Xn2 = 1;
		int fib = 0;
		for(int i = 0; i < n - 1; i++) {
			fib = Xn1 + Xn2;
			Xn1 = Xn2;
			Xn2 = fib;
		}
		return fib;
	}

}
