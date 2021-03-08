
public class BinarySearchTree {
	Tnode root;
	int i = 0;
	public void insert(int key) {
		root = insert(this.root , key);
	}
	
	private Tnode insert(Tnode root, int key) {
		//if the node is empty, add a new node
		if(root == null) {
			root = new Tnode(key);
			return root;
		}
		//make a comparison while traversing the tree recursively
		
		// if the key is bigger in value go right
		if(key > root.key) root.right = insert(root.right, key);

		//if the key is smaller in value go left
		if(key < root.key) root.left = insert(root.left, key);
		
		//return the new root at the end
		return root;

	}
	
	public boolean contains(int key) {
		return contains(root, key);
	}
	
	
	private boolean contains(Tnode root, int key) {
		
		//end conditions for the recursion
		if(root == null) return false;
		if(root.key == key) 
			return true;

		//traversing the tree recursively
		if(root.key > key) return contains(root.left, key);

		if(root.key < key) return contains(root.right, key);
		
		return false;
	}
	
	public int getSum() {
		return getSum(root);
	}
	
	private int getSum(Tnode root) {
		//end condition for the recursion
		if(root == null) return 0;
		
		return root.key + getSum(root.left) + getSum(root.right);
	}
	
	public int getCount() {
		return getCount(root);
	}
	
	private int getCount(Tnode root) {
		if(root == null) return 0;
		
		return 1 + getCount(root.left) + getCount(root.right);
	}
	
	public int getMax() {
		return getMax(root);
	}
	
	private int getMax(Tnode root) {
		//end condition returns the minimum value
		if(root == null) return Integer.MIN_VALUE;
		
		//getting the key value of each node
		int curr = root.key;
		int lcurr = getMax(root.left);
		int rcurr = getMax(root.right);
		//making the comparison
		 if(curr < lcurr) curr = lcurr;
		 if(curr < rcurr) curr = rcurr;
		 
		return  curr;
	}
	
	public int getMin() {
		return getMin(root);
	}
	
	private int getMin(Tnode root) {
		//returns the maximum value as an end condition for recursion
		if(root == null) return Integer.MAX_VALUE;
		
		//getting key value of each node in the tree
		int curr = root.key;
		int lcurr = getMin(root.left);
		int rcurr = getMin(root.right);
		//making the comparison
		if(curr > lcurr) curr = lcurr;
		if(curr > rcurr) curr = rcurr;
		
		return curr;
	}
	
	public int numOfLeaves() {
		return numOfLeaves(this.root);
	}
	
	private int numOfLeaves(Tnode root) {
		//end condition for recursion
		if(root == null) return 0;
		//when we reach the leaf nodes we return 1
		if(root.right == null && root.left == null) return 1;
		//traversing the tree recursively till we reach the leaf nodes that returns
		// 2 or 1 or whether the parent of the leaf nodes has 2 or 1 children
		else return numOfLeaves(root.left) + numOfLeaves(root.right);
		
		
	}
	
	public int countPositive(Tnode root) {
		if(root == null) return 0;
		
		if(root.key > 0)  return 1 + countPositive(root.left) + countPositive(root.right);
		
		else return countPositive(root.left) + countPositive(root.right);
	}
	
	public boolean equals(BinarySearchTree tree) {
		return equals(this.root, tree.root);
	}
	
	private boolean equals(Tnode root1, Tnode root2) {
		//if both are empty trees it returns true
		if(root1 == null && root2 == null) return true;
		//if both are not empty then we make a comparison
		if(root1 !=null && root2!= null)
			//compare the value of the two corresponding nodes
			return(root1.key == root1.key
					&& equals(root1.left, root2.left) //traverse to the left side of the tree
					&& equals(root1.right, root2.right)); //traverse to the right side of the tree
		
		return false;
	}
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(Tnode root) {
		
		if(root != null) {
			inorder(root.left);
			System.out.println(root.key);
			inorder(root.right);
		}
	}
	
	public void preorder() {
		preorder(root);
	}
	
	private void preorder(Tnode root) {
		
		if(root != null) {
			System.out.println(root.key);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void postorder() {
		postorder(root);
	}
	
	private void postorder(Tnode root) {
		
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.key);
		}
	}
	

}
