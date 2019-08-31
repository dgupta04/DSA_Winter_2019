import java.util.Scanner;
class Node{
	int parent, data;
	Node left, right;
	Node(int n, int p){
		data =n;
		parent = p;
		left = null;
		right = null;
	}
}

class SortTree{
	Node root;
	SortTree(){
		root = null;
	}
	
}

public class L8{
	// public static void writePar(int[] a, int[] par, int start, int end, int prev){
	// 	par[(start+end)/2] = a[prev];
	// 	if(start == end-2){
	// 		par[start] = a[start+1];
	// 		par[end] = a[start+1];
	// 	}
	// 	else{
	// 		writePar(a, par, start, ((start+end)/2)-1, (start+end)/2);
	// 		writePar(a, par, ((start+end)/2)+1, end, (start+end)/2);
	// 	}
	// }
	public Node makeTree(int[] a, int start, int end, int prev, int n){
		int m = (start+end)/2;
		if(start>end){
			return null;
		}
		if(start == 0 && end==n-1){
			Node r = new Node(a[m], 0);
		}
		else{
			Node r = new Node(a[m], prev)
		}
		r.left = makeTree(a, start, mid-1, a[m], n);
		r.right = makeTree(a, mid+1, end, a[m], n);
		return r;
	}		
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] p = new int[n];
		Node root = 
		for(int i =0; i<n; i++){
			a[i] = s.nextInt();
		}
		Node root = makeTree(a,0,n-1,0,n);
		// p[n/2] = 0;
		// if(n==3){
		// 	System.out.println(a[1]);
		// 	System.out.println(0);
		// 	System.out.println(a[1]);
		// }
		// else{
		// 	writePar(a,p,0,(n/2)-1, n/2);
		// 	writePar(a,p,(n/2)+1, n-1, n/2);
		// 	for(int i=0; i<n;i++){
		// 		System.out.print(p[i] + " ");	
		// 	}		
		}
}