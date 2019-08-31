import java.util.Scanner;
import java.util.ArrayList;

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
	}
	boolean cycleDetectFun(int vert, boolean[] visBool, boolean[] det){
		if(det[vert-1] == true){
			return true;
		}
		if(visBool[vert-1] == true){
			return false;
		}
		visBool[vert-1] = true;
		det[vert-1] = true;	
		ArrayList<Integer> neigh = adjList.get(vert-1);
		for(int i=0; i<neigh.size(); i++){
			if(cycleDetectFun(neigh.get(i), visBool, det)){
				return true;
			};
		}
		det[vert-1] = false;
		return false;
	}
	boolean cycleDetect(){
		boolean[] visBool = new boolean[n];
		boolean[] det = new boolean[n];

		for(int i=0; i<n; i++){
			if(cycleDetectFun(vertices[i], visBool, det)){
				return true;
			}
		}
		return false;
	}
}

public class L11_1{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] vert = new int[n];
		for(int i=0; i<n; i++){
			vert[i] = i+1;
		}
		Graph g = new Graph(n, vert);
		for(int i=0; i<m; i++){
			int a = s.nextInt();
			int b = s.nextInt();
			g.addEdge(a,b);
		}
		if(n==1 || n==2){
			System.out.println(0);
			return;
		}
		if(g.cycleDetect()){
			System.out.println(1);
		}
		else{
			System.out.println(0);
		}
	}
}