class Node{
	int data;
	Node next;
	Node(int n){
		data = n;
	}
}

class LinkList{
	Node front;
	LinkList(){
		front = null;
	}
	void InsertAtEnd(Node f, int n){
		Node temp = f;
		if(front == null){
			temp = new Node(n);
			front = temp;
		}
		else{
			if(temp.next == null){
				Node x = new Node(n);
				temp.next = x;
				return;
			}
			if(temp.next != null){
				InsertAtEnd(temp.next, n);
			}
		}
	}
	void printList(Node f){
		if(f == null){
			return;
		}
		else{
			System.out.print(f.data + "->");
			printList(f.next);
		}
	}
}

public class RecLinked{
	public static void main(String[] args) {
		LinkList l = new LinkList();
		for(int i=0; i<5; i++){
			l.InsertAtEnd(l.front, i);
		}
		l.printList(l.front);
	}
}

