import java.util.Scanner;

class Heap{
	int[] h;
	int size;

	Heap(int n){
		h = new int[n];
		size = 0;
	}
	void insert(int x){
		if(size == 0){
			h[0] = x;
			size++;
		}
		else{
			h[size] = x;
			size++;
			int i = size-1;
			while(i>0){
				if(h[i] < h[(i-1)/2]){
					int temp = h[i];
					h[i] = h[(i-1)/2];
					h[(i-1)/2] = temp;
				}
				i = (i-1)/2;
			} 
		}
	}
	void printHeap(){
		for(int i=0; i<size; i++){
			System.out.print(h[i] + " ");
		}
		System.out.println();
	}
}

public class HeapNew{
	public static void main(String[] args) {
		Heap h = new Heap(20);
		Scanner s = new Scanner(System.in);
		for(int i=0; i<10; i++){
			int n = s.nextInt();
			h.insert(n);
			h.printHeap();
		}
	}
}