import java.util.Stack;

public class PostfixAndPrefix {


	public static void main(String[] args) {
		//System.out.println(evaluatePostfix("23*54*+9-"));
		//System.out.println(evaluatePrefix("-+*23*549"));
		System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));

	}
	
	public static int perc(char operator) {
		switch(operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
	
	public static String infixToPostfix(String exp) {
		String result = "";
		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if(Character.isLetterOrDigit(c)) result += c;
			else if(c == '(') s.push(c);
			else if(c == ')') {
				while(!s.isEmpty() && s.peek() != '(') result += s.pop();
				s.pop();
			}
			else {
				while(!s.isEmpty() && perc(c) <= perc(s.peek())) result += s.pop();
				s.push(c);
			}
		}
		while(!s.isEmpty()) result += s.pop();
		
		return result;
	}
	
	public static double evaluatePostfix(String exp) {
		Stack<Double> s = new Stack<Double>();
		for(char element : exp.toCharArray()) {
			 if(Character.isDigit(element)){
				s.push((double) element-'0');
			 }
			 else
			 {
				 double op1 = s.pop();
				 double op2 = s.pop();
				 double result = performPostfix(op1, op2, element);
				 s.push(result);
			 }
		}
		return s.pop();
	}
	public static double performPostfix(double op1, double op2, char operator) {
		switch(operator) {
		case '+':
			return op1 + op2;
		case '-':
			return op2 - op1;
		case '*':
			return op1 * op2;
		case '/':
			return op2 / op1;
		}
		return 0;
	}
	
	public static double evaluatePrefix(String exp) {
		Stack<Double> s = new Stack<Double>();
		for(int i = exp.length()-1; i >=0; i--) {
			char element = exp.charAt(i);
			 if(Character.isDigit(element)){
				s.push((double) element-'0');
			 }
			 else
			 {
				 double op1 = s.pop();
				 double op2 = s.pop();
				 double result = performPrefix(op1, op2, element);
				 s.push(result);
			 }
		}
		return s.pop();
	}
	
	public static double performPrefix(double op1, double op2, char operator) {
		switch(operator) {
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 * op2;
		case '/':
			return op1 / op2;
		}
		return 0;
	}
	
	
	
	


}
