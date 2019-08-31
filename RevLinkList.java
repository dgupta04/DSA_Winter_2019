import java.util.Scanner;

class Node{
        public int data;
        public Node next;
        Node(int dat){
            data = dat;
            next = null;
        }
}

public class RevLinkList{
	public static Node revList(Node curr, Node rest, Node next){
		if(next==null){
			rest.next = curr;
			return rest;
		}
		else{
			rest.next = curr;
			curr = rest;
			rest = next;
			next = next.next;
			return revList(curr, rest, next);
		}
	}
	 public static Node addNode(int data, Node front){
        Node tmp = new Node(data);
        if(front == null){
            front = tmp;
        }
        else{
        Node t = front;
        while(t.next != null){
            t = t.next;
        }
        t.next = tmp;
    }
    return front;
    }
    public static void printList(Node front){
        if(front==null){
            System.out.println("List is empty");
        }
        else{
        Node t = front;
        while(t.next != null){
            Node temp = t;
            System.out.print(Integer.toString(t.data) + "->");
            t = temp.next;
            temp = t;
        }
        System.out.println(Integer.toString(t.data));  
        }
    }
    
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);   
		 int n = s.nextInt();
   		 Node front = null;	
		for(int i = 0; i<n; i++){
		System.out.print("Data value for node: ");
        int newData = s.nextInt();
        front = addNode(newData, front);
    }
    printList(front);
    Node curr= front;
    Node rest = front.next;
    Node next = rest.next;
    curr.next=  null;
    front = revList(curr,rest,next);
    printList(front);
	}
}