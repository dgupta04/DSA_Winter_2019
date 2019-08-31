import java.util.Scanner;


class Node{
	int data, height;
	Node right, left;
	Node(){
		data = 0;
		left = null;
		right = null;
	}
	Node(int d){
		data = d;
		left = null;
		right = null;
	}
}

class AVLTree{
	Node root;
	private int height(Node n){
		if(n==null){
			return 0;
		}
		return n.height;
	}
	private int max(int a, int b){
		return (a>b)? a:b;
	}
	
}