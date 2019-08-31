public class merge{
	public static int[] mergeSortInc(int[] input, int start, int end){
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
			System.out.println(c[k]);
			k++;
		}
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
		int[] a = {3,4,2,5,7,8,3,1,9};
		int[] b = mergeSortInc(a, 0, a.length-1);
		for(int i=0; i<b.length; i++){
			System.out.print(b[i] + " ");
		}
	}
}