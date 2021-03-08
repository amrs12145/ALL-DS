
public class DLL {
	dllNode head;
	
	public void append(int input) {
		
		if(head == null) head = new dllNode(input);
		
		else {
			dllNode newNode = new dllNode(input);
			dllNode curr = head;
			while(curr.next != null)
				curr = curr.next;
				
			curr.next = newNode;
			newNode.prev = curr;
		}
	}
	
	public void prepend(int input) {
		dllNode newNode = new dllNode(input);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	
	public void reverse() {
		if(head == null) return;
		
		dllNode temp = null;
		dllNode curr = head;
		while(curr != null) {
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			curr = curr.prev;
		}
		
		if(temp != null) head = temp.prev;
	}
	
	public void recurReverse(dllNode curr, dllNode temp) {
		if(head == null) return;
		
		if(curr == null)
			if(temp != null) {
				head = temp.prev;
				return;
			}
		temp = curr.prev;
		curr.prev = curr.next;
		curr.next = temp;
		recurReverse(curr.prev, temp);
		
	}
	
	public void recurReverse() {
		dllNode curr = head;
		dllNode temp = null;
		recurReverse(curr, temp);
	}
	
	public void deleteWithValue(int input) {
		if(head == null) return;
		if(head.data == input) {
			head = head.next;
			}
		
		else {
			dllNode curr = head;
			while(curr.data != input)
					curr = curr.next;
			
			if (curr.next != null) {
	            curr.next.prev = curr.prev;
			}
	 

	        if (curr.prev != null) {
	            curr.prev.next = curr.next;
	        }
		}
	}
	
	public void deleteNode(dllNode curr) {
		if(curr == null) return;
		if(curr == head) head = head.next;
		
		if (curr.next != null) {
            curr.next.prev = curr.prev;
		}
 

        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }
	}
	
	public void print() {
		dllNode curr = head;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}
	
	public void deleteDuplicate() {
		dllNode curr1 = head ,curr2;
		while(curr1 != null) {
			curr2 = curr1.next;
			while(curr2 != null) {
				if(curr1.data == curr2.data) deleteNode(curr2);
				curr2 = curr2.next;
			}
			curr1 = curr1.next;
		}
	}
	
	public void deleteAllOccur(int input) {
		dllNode curr = head;
		while(curr != null) {
			if(curr.data == input) deleteNode(curr);
			curr = curr.next;
		}
	}
	
	public boolean search(int input) {
		dllNode curr = head;
		while(curr != null) {
			if(curr.data == input) return true;
			curr = curr.next;
		}
		return false;
	}
	
	public boolean recurSearch(int input, dllNode curr) {
		if(curr == null) return false;
		if(curr.data == input) return true;
		return recurSearch(input, curr.next);
	}
	
	public boolean recurSearch(int input) {
		return recurSearch(input, head);
	}
	
	public boolean isPalindrome() {
		dllNode tail = getTail();
		dllNode curr = head;
		while(curr != tail) {
			if(curr.data != tail.data) return false;
			curr = curr.next;
			tail = tail.prev;
		}
		return true;
	}
	
	public boolean recurIsPalindrome(dllNode curr, dllNode tail) {
		if(curr == tail) return true;
		if(curr.data != tail.data) return false;
		return recurIsPalindrome(curr.next, tail.prev);
	}
	
	public boolean recurIsPalindrome() {
		dllNode curr = head;
		dllNode tail = getTail();
		return recurIsPalindrome(curr, tail);
	}
	
	public dllNode getTail() {
		if (head == null) return null;
		dllNode tail = head;
		while(tail.next != null)
			tail = tail.next;
		return tail;
	}
	

}
