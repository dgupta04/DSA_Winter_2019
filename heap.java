import java.util.Scanner;

class MaxHeap{
	int[] h;
	int size;
	MaxHeap(int maxsize){
		h = new int[maxsize+1];
		h[0] = Integer.MAX_VALUE;
		h[1] = 1;
		size = 1;
	}
	public void swap(int a, int b){
		int tmp = h[a];
		h[a]=h[b];
		h[b]=tmp;
	}
	public void insert(int x){
		size++;
		// System.out.println("size " + size);
		h[size] = x;
		int ptr = size;

		while(h[ptr]>h[ptr/2]){
			// System.out.println("ptr " + ptr );
			swap(ptr, ptr/2);
			ptr = ptr/2;
		}
		maxHeapify(2);
	}
	public void maxHeapify(int x){
		if(leaf(x)){
			return;
		}
		else if(h[x]<h[2*x] || h[x]<h[(2*x)+1]){
			if(h[x]<h[2*x]){
				swap(x, 2*x);
				maxHeapify(2*x);
			}
			if(h[x]<h[(2*x)+1]){
				swap(h[x], h[(2*x)+1]);
				maxHeapify((2*x)+1);		
			}
		}
	}
	public boolean leaf(int i){
		if(i==1){
			return false;
		}
		return (i>=(size/2) && i<=size);
	}
	public int popMax(){
		int a = h[1];
		h[1] = h[size];
		size-=1;
		System.out.println();
		maxHeapify(1);
		return a;
	}
	public int printMax(){
		return h[1];
	}
}
public class heap{
	public static void main(String[] args) {
		MaxHeap h1 = new MaxHeap(100000);
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] out = new int[n];
		int outc = 0;
		for(int i=0; i<n; i++){
			int q = s.nextInt();
			if(q==1){
				int x = s.nextInt();
				h1.insert(x);
			}
			if(q==2){
				out[outc++] = h1.printMax();
				// System.out.println(out[outc-1]);
			}
			if(q==3){
				h1.popMax();
			}
			for(int j=1; j<=h1.size; j++){
				System.out.print(h1.h[j] + " ");
			}
			System.out.println();
		}
		for(int i=0; i<outc; i++){
			System.out.println(out[i]);
		}
	}
}