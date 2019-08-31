import java.util.Scanner;

public class L9_1{
	
	public static void insert(int i, int heap[], int size) {
		heap[size] = i;
		int maxInd = size;
		int newMax = (maxInd-1)/2;
		while(maxInd > 0) {	
			if(heap[maxInd] > heap[newMax]) {
				int x = heap[maxInd];
				heap[maxInd] = heap[newMax];
				heap[newMax] = x;
				maxInd = newMax;
				newMax = (maxInd - 1) / 2;
			}else {
				return;
			}
		}
	}	
	public static int printMax(int heap[]){
		return heap[0];
	}
	
	public static void delMax(int heap[], int size) {
		heap[0] = heap[size-1];
		int ptr = 0;
		int greaterInd = ptr;
		int left = 1;
		int right = 2;
		while(left < size) {
			if(heap[left] > heap[greaterInd]) {
				greaterInd = left;
			}
			if(right < size && heap[right] > heap[greaterInd]) {
				greaterInd = right;
			}
			if(greaterInd == ptr) {
				break;
			}else {
				int temp = heap[ptr];
				heap[ptr] = heap[greaterInd];
				heap[greaterInd] = temp;
				ptr = greaterInd;
				left = 2 * ptr +1;
				right = 2 * ptr +2;
			}
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int heap[] = new int[100000];
		heap[0] = 1;
		int size = 1;
		int n = s.nextInt();
		int[] out = new int[n];
		int outc = 0;
		for(int i=0; i<n; i++) {
			int q = s.nextInt();
			if(q == 1) {
				int x = s.nextInt();
				insert(x, heap, size);
				size++;
			}else if(q == 2) {
				out[outc++] = printMax(heap);
			}else if(q == 3) {
				delMax(heap, size);
				size--;
			}else {
				continue;
			}
		}
		for(int i=0; i<outc; i++){
			System.out.println(out[i]);
		}
	}
}
