class Node{
	int data;
	Node left;
	Node right;

	Node(int i){
		data = i;
	}
}

public class tree{
	public static int maxDepth(Node root, int count){
		if(root == null){
			return count-1;
		}
		else{
			int a = maxDepth(root.left, count+1);
			int b = maxDepth(root.right, count+1);
			return (a>b)? a:b;
		}
	}
	public static void preorder(Node root){
		if(root==null){
			System.out.print("");
		}
		else{
			System.out.print(Integer.toString(root.data) + " ");
			preorder(root.left);			
			preorder(root.right);

		}
	}
	public static void main(String[] args) {
	Node root = new Node(0);
	Node[] a = new Node[9];
	for(int i=0; i<9; i++){
		Node n = new Node(i+1);
		a[i] = n;
	}
	root.left = a[0];
	root.right = a[1];
	root.left.left = a[2];
	root.left.right = a[3];
	root.left.right.right = a[4];
	root.right.left = a[5];
	root.right.right = a[6];
	root.right.right.left = a[7];
	root.right.right.left.right = a[8];	
	System.out.println(maxDepth(root,0));
	preorder(root);
	}		
}