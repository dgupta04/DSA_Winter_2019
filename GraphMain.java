import java.util.ArrayList;

// class Node{
// 	int data;
// 	Node next;
// 	Node(int n){
// 		data = n;
// 		next = null;
// 	}
// }

// // class AdjacencyList{
// 	// Node front;
// 	// Node rear;
// 	// AdjacencyList(int n){
// 	// 	Node temp = new Node(n);
// 	// 	front = temp;
// 	// 	rear = front;
// 	// }
// 	// void addNodeAdj(int n){
// 	// 	Node temp = new Node(n);
// 	// 	System.out.println(rear==front);
// 	// 	if(rear==front){
// 	// 		front.next = temp;
// 	// 		rear = front.next;
// 	// 	}
// 	// 	else{
// 	// 		rear.next = temp;
// 	// 		rear = rear.next;
// 	// 	}
// 	// }
// }

// class BFSQueue{
// 	Node front;
// 	Node rear;
// 	BFSQueue(){
// 		front = null;
// 		rear = null;
// 	}
// 	void addNode(int n){
// 		Node temp = new Node(n);
// 		if(front==null){
// 			front = temp;
// 			rear = front;
// 		}
// 		if(rear==front){
// 			front.next = temp;
// 			rear = front.next;
// 		}
// 		else{
// 			rear.next = temp;
// 			rear = rear.next;
// 		}
// 	}
// 	int dequeue(){
// 		int a;
// 		if(front==rear){
// 			a = front.data;
// 			front = null;
// 			rear = null;
// 			return a;
// 		}
// 		else{
// 			a = front.data;
// 			front = front.next;
// 			return a;
// 		}
// 	}
// 	boolean isEmpty(){
// 		return (front==null && rear == null);
// 	}
// }

class Graph{
	int n;
	int[] vertices;
	ArrayList<ArrayList<Integer>> adjList;
	Graph(int x, int[] vert){
		n=x;
		vertices = vert;
		adjList = new ArrayList<>(n);
		for(int i=0; i<n; i++){
			adjList.add(new ArrayList<Integer>());
		}
	}
	void addEdge(int source, int dest){
		adjList.get(source-1).add(dest);
		adjList.get(dest-1).add(source);
	}
	
	int[] BFSPath(int source){
		ArrayList<Integer> q = new ArrayList<Integer>();
		int[] dist = new int[n];
		boolean[] visi = new boolean[n];
		ArrayList<ArrayList<Integer>> a = adjList; 
		for(int i=0; i<n; i++){
			dist[i] = Integer.MAX_VALUE;
			visi[i] = false;
		}
		dist[source-1] = 0;
		visi[source-1] = true;
		q.add(source);
		while(!(q.isEmpty())){
			int c = q.remove(0);
			for(int i=0; i<a.get(c-1).size();i++){
				if(visi[a.get(c-1).get(i)-1]==false){
					visi[a.get(c-1).get(i)-1] = true;
					dist[a.get(c-1).get(i)-1] = dist[c-1] + 1;
					q.add(a.get(c-1).get(i));
				}
			}
		}
		return dist;
	}
	// void BFS(int source){
	// 	boolean[] visited = new boolean[n];
	// 	int[] distance = new int[n];
	// 	BFSQueue q = new BFSQueue();
	// 	for(int i=0; i<n; i++){
	// 		visited[i] = false;
	// 		distance[i] = Integer.MAX_VALUE;
	// 	}
	// 	int start = 0;
	// 	visited[source-1] = true;
	// 	distance[source-1] = 0;
	// 	q.addNode(source);
	// 	while(!(q.isEmpty())){
	// 		int c = q.dequeue();
	// 		System.out.print(c + " ");
	// 		Node t = a[c-1].front;
	// 		while(t.next!=null){
	// 			if(distance[t.next.data-1] == Integer.MAX_VALUE){
	// 				q.addNode(t.next.data);
	// 				visited[t.next.data-1] = true;
	// 				distance[t.next.data-1] = distance[c-1]+1;
	// 				t = t.next;
	// 			}
	// 		}
	// 	}
	// }
}

public class GraphMain{
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
		// for(int i=0; i<6;i++){
		// 	for(int j=0; j<g.adjList.get(i).size(); j++){
		// 		System.out.println(g.adjList.get(i).get(j));
		// 	}
		// }
		int[][] allPaths = new int[6][6];
		
		for(int i=1; i<=6;i++){
			int[] allDist = g.BFSPath(i);
			for(int j=0; j<6; j++){
				System.out.print(allDist[j] + " ");
			}
			System.out.println();
			allPaths[i-1] = allDist;
		}
	}
}