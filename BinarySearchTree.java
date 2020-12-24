
public class BinarySearchTree {
	
	class Node{
		int data;
		Node left ;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		
	}
	
	Node root = null;
	
	void insert(int key)  
    {  
         root = insertRec(root, key);  
    } 
	
	public Node insertRec(Node root, int key) {
		
		if(root == null) {
			root = new Node(key);
			return root;
		}
		
		if (key < root.data) 
            root.left = insertRec(root.left, key); 
        else if (key > root.data) 
            root.right = insertRec(root.right, key); 
		
		return root;
	}
	
	
	public boolean search(Node root, int key) {
		
		if(root == null) return false;
		
		if(root.data == key) return true;
		boolean left = false ;
		boolean right = false;
		if(root.data > key) {
			left = search(root.left, key);
		}else {
			right = search(root.right, key);
		}
		
		return left || right;
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree  tree = new BinarySearchTree();
		
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
        
        
	}

}
