import java.util.Scanner;

class Node{
        public int data;
        public Node next;
        Node(int dat){
            data = dat;
            next = null;
        }
        Node(int dat, Node link){
        	data = dat;
        	next = link;
        }
}

public class L5_1{
	public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	Node tmp = new Node(1);
	Node rear = tmp;
	rear.next = rear;
	Node curr = rear;
	int n = s.nextInt();
	for(int i=1; i<=n ;i++){
		int q = s.nextInt();
		if(q==1){
			int newData = s.nextInt();
			Node newNode = new Node(newData);
			if(curr == rear){
				newNode.next = curr.next;
				curr.next = newNode;
				rear = newNode;
			}
			else{
				newNode.next = curr.next;
				curr.next = newNode;
			}
		}
		if(q==2){
			curr = curr.next;
		}
		if(q==3){
			// System.out.print(">>");
			System.out.println(curr.data);}
	}
	}
}
