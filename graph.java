
class Node{
	int data;
	Node next;
	Node(int n){
		data = n;
		next = null;
	}
}

class AdjacencyList{
	Node front;
	Node rear;
	AdjacencyList(int n){
		front = new Node(n);
		rear = front;
	}
	void addNode(int n){
		Node temp = new Node(n);
		if(rear==front){
			front.next = temp;
			rear = front.next;
		}
		else{
			rear.next = temp;
			rear = rear.next;
		}
	}
}

class BFSQueue{
	Node front;
	Node rear;
	BFSQueue(){
		front = null;
		rear = null;
	}
	void addNode(int n){
		Node temp = new Node(n);
		if(front==null){
			front = temp;
			rear = front;
		}
		if(rear==front){
			front.next = temp;
			rear = front.next;
		}
		else{
			rear.next = temp;
			rear = rear.next;
		}
	}
	int dequeue(){
		int a;
		if(front==rear){
			front = null;
			rear = null;
			return 0;
		}
		else{
			a = front.data;
			front = front.next;
			return a;
		}
	}
	boolean isEmpty(){
		return (front==null && rear == null);
	}
}

class Graph{
	int n;
	int[] vertices;
	AdjacencyList a[];

	Graph(int x, int[] vert){
		n=x;
		vertices = vert;
		AdjacencyList a[] = new AdjacencyList[n];
		for(int i=0; i<n;i++){
			a[i] = new AdjacencyList(vertices[i]);
		}
	}
	void addEdge(int source, int dest){
		a[source-1].addNode(dest);
	}
	
	void BFS(int source){
		boolean[] visited = new boolean[n];
		int[] distance = new int[n];
		BFSQueue q = new BFSQueue();
		for(int i=0; i<n; i++){
			visited[i] = false;
			distance[i] = Integer.MAX_VALUE;
		}
		int start = 0;
		visited[source-1] = true;
		distance[source-1] = 0;
		q.addNode(source);
		while(!(q.isEmpty())){
			int c = q.dequeue();
			System.out.print(c + " ");
			Node t = a[c-1].front;
			while(t.next!=null){
				if(distance[t.next.data-1] == Integer.MAX_VALUE){
					q.addNode(t.next.data);
					visited[t.next.data-1] = true;
					distance[t.next.data-1] = distance[c-1]+1;
					t = t.next;
				}
			}
		}
	}
}

public class graphMain{
	public static void main(String[] args) {
		int[] vertices = {1,2,3,4,5,6};
		Graph g = new Graph(6, vertices);
		// g.addVertices(vertices);
		g.addEdge(1,4);
		g.addEdge(1,2);
		g.addEdge(2,4);
		g.addEdge(3,5);
		g.addEdge(3,6);
		g.addEdge(5,1);
		g.addEdge(5,6);
	}
}