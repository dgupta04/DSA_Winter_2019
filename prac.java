class Node{
        public int data;
        public Node next;
        Node(){
        	next = null;
        
        }
        Node(int dat){
            data = dat;
            next = null;
        }
}

class LinkedList{
	static Node front;
	LinkedList(){
		front = null;
	}
	public static void push(int data){
		Node tmp = new Node(data);
		if(front==null){
			front = tmp;
		}
		else{
		Node t = front;
        while(t.next != null){
            t = t.next;
        }
        t.next = tmp;	
		}
	}
	public static void display(){
		Node tmp = front;
		while(tmp!=null){
			System.out.print(tmp.data + "->");
			tmp = tmp.next;
		}
		System.out.println();
	}
}

public class prac{
	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		LinkedList l2= new LinkedList();
		public static LinkedList maxSum(Node front1, Node front2){
			int sum1 = 0;
			int sum2 = 0;
			Node temp1= front1;
			Node temp2= front2;
			sum1 += temp1.data;
			sum2 += temp2.data;
			temp1 = temp1.next;
			temp2 = temp2.next;
			l1.push(temp1.data);
			l1.push(temp2.data);
			while(temp1!=null || temp2!=null){
				if(sum1<=sum2){
					Node t = temp1;
					temp1 = temp2;
					temp2 = t;
				}
			}
		}
	}
}