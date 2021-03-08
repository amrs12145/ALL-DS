import java.util.*;
public class BalancedParenthesis {

	public static void main(String[] args) {
		String test = "(2+1){koko}[babygurl]";
		boolean result = checkBalancedParenthesis(test);
		System.out.println(result);

	}
	
	public static boolean checkBalancedParenthesis(String exp) {
		Stack<Character> s = new Stack<Character>();
		for(char paren : exp.toCharArray()) {
			if(paren == '(' || paren == '{' || paren == '[') {
				s.push(paren);
			}
			
			else if(paren == ')' || paren == '}' || paren == ']') {
				if(s.isEmpty() || !arePair(s.peek(),paren)) return false;
				else s.pop();
			}
		}
		return s.isEmpty();
	}
	public static boolean arePair(char opening ,char closing) {
		if(opening == '(' && closing == ')') return true;
		else if(opening == '{' && closing == '}') return true;
		else if(opening == '[' && closing == ']') return true;
		return false;

	}
		}


