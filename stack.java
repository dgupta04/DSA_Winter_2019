import java.util.Scanner;

class Node{
	static int data;
	static Node next;
	static Node prev;

	Node(int dat, Node nex, Node pre){
		data = dat;
		next = nex;
		prev = pre;
	}
}

public class stack{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Node head = new Node(null, null, null);
		int n = s.nextInt();
		for(int i = 0; i<n ;i++){
			int dat = s.nextInt();
			Node item = new Node(dat, , )
		}
	}
}