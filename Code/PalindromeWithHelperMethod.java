
public class PalindromeWithHelperMethod {

	public static void main(String[] args) {
		System.out.println(isPalindrome("LOOL"));
		System.out.print(isPalindrome("LMFAO"));

	}
	
	//overloading the helper method 
	public static boolean isPalindrome(String s) {
		//calling the helper method
		return isPalindrome(s, 0, s.length()-1);
	}
	
	//helper recursive methode
	public static boolean isPalindrome(String s,int first,int last) {
		//base condition
		if(last <= first) return true;
		//return false if not Palindrome
		else if(s.charAt(first) != s.charAt(last)) return false;
		//recursive call
		return isPalindrome(s, first + 1, last - 1);
	}

}
