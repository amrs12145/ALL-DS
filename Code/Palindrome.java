
public class Palindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("LOOL"));
		System.out.print(isPalindrome("LMFAO"));

	}
	
	public static boolean isPalindrome(String s) {
		//base condition
		if(s.length() <= 1) return true;
		//return false if string isn't a Palindrome
		else if(s.charAt(0) != s.charAt(s.length()-1)) return false;
		//recursive call (shrinks the string from both sides by 1 char)
		return isPalindrome(s.substring(1,s.length()-1));
	}

}
