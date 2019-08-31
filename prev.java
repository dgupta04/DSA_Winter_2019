import java.util.Scanner;

public class prev{
	public static int[] mergeSortInc(int[] input, int start, int end){
		int mid = (start+end)/2;
		if(start==end){
			int[] e = new int[1];
			e[0] = input[start];
			return e;
		}
		else if(start == end-1){
			int[] ret = new int[2];
			if(input[start]<input[end]){
				ret[0] = input[start];
				ret[1] = input[end];
			}
			else{
				ret[0] = input[end];
				ret[1] = input[start];
			}
			return ret;
		}
		int[] a = mergeSortInc(input, start, mid);
		int[] b = mergeSortInc(input, mid+1, end);
		// for(int l=0; l<a.length; l++){
		// 	System.out.print(a[l] + " ");
		// }
		// System.out.println();
		// for(int l=0; l<b.length; l++){
		// 	System.out.print(b[l] + " ");
		// }
		// System.out.println();
		// System.out.println(b);
		int[] c = new int[end-start+1];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<a.length && j<b.length){
			if(a[i]<=b[j]){
				c[k] = a[i];
				i++;
			}
			else{
				c[k] = b[j];
				j++;
			}
			// System.out.println(c[k]);
			k++;
		}
		// System.out.println(i + " i ");
		// System.out.println(j + " j ");
		// System.out.println(k + " k ");
		while(i<a.length){
			c[k] = a[i];
			i++;
			k++;
		}
		while(j<b.length){
			c[k] = b[j];
			j++;
			k++;
		}
		return c;
	}
	public static int[] mergeSortDec(int[] input, int start, int end){
		int mid = (start+end)/2;
		if(start==end){
			int[] e = new int[1];
			e[0] = input[start];
			return e;
		}
		else if(start == end-1){
			int[] ret = new int[2];
			if(input[start]>input[end]){
				ret[0] = input[start];
				ret[1] = input[end];
			}
			else{
				ret[0] = input[end];
				ret[1] = input[start];
			}
			return ret;
		}
		int[] a = mergeSortInc(input, start, mid);
		int[] b = mergeSortInc(input, mid+1, end);
		// for(int l=0; l<a.length; l++){
		// 	System.out.print(a[l] + " ");
		// }
		// System.out.println();
		// for(int l=0; l<b.length; l++){
		// 	System.out.print(b[l] + " ");
		// }
		// System.out.println();
		// System.out.println(b);
		int[] c = new int[end-start+1];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<a.length && j<b.length){
			if(a[i]>=b[j]){
				c[k] = a[i];
				i++;
			}
			else{
				c[k] = b[j];
				j++;
			}
			// System.out.println(c[k]);
			k++;
		}
		// System.out.println(i + " i ");
		// System.out.println(j + " j ");
		// System.out.println(k + " k ");
		while(i<a.length){
			c[k] = a[i];
			i++;
			k++;
		}
		while(j<b.length){
			c[k] = b[j];
			j++;
			k++;
		}
		return c;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String[] ans = new String[n];
		for(int i=0; i<n; i++){
			int k = s.nextInt();
			int t = s.nextInt();
			int m = s.nextInt();
			int x = s.nextInt();
			int[] a = new int[k];
			for(int j=0; j<k; j++){
				a[j] = s.nextInt();
			}
			if(m==1){
				int[] sortIQ = mergeSortDec(a, 0, a.length-1);
				int sumIQ = 0;
				for(int l=0; l<x; l++){
					sumIQ += sortIQ[l];
				}
				sumIQ/=x;
				ans[i] = (sumIQ>t)? "HOPEFUL":"HOPELESS";
			}
			else{
				int[] sortIQ = mergeSortInc(a, 0, a.length-1);
				int sumIQ = 0;
				for(int l=0; l<x; l++){
					sumIQ += sortIQ[l];
				}
				sumIQ/=x;
				ans[i] = (sumIQ>t)? "HOPEFUL":"HOPELESS";
			}
		}
		for(int i=0; i<n; i++){
			System.out.println(ans[i]);
		}
	}
}