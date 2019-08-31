import java.util.Scanner;

public class L7P1{
	public static void main(String[] args) {
		long sum = 0;
		long out = 0;
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		long[] a = new long[n];
		for(int i=0; i<n; i++){
			a[i] = s.nextInt();
		}
		if(n==k){
			for(int i=0; i<n; i++){
				sum += a[i];
			}
			System.out.println(sum);
			return;
		}
		else{
			long minSum = Long.MAX_VALUE;	
			int start = 0;
			int end = k-1;
			int min = k-1;
			for(int i=0; i<=end; i++){
				sum+= a[i];
				if(a[i]<=a[min])
				{
					min = i;
				}
			}
			out = sum - k*a[min];
			while(end<n-1){
				sum += (a[end+1] - a[start]);
				if(min == start){
					min = start+1;
					for(int i=start+1; i<=end+1; i++){
						if(a[i]<=a[min]){
							min = i;
						}
					}
				}
				else if(min!=start && a[end+1]<a[min]){
					min = end+1;
				}
				long m = sum - k*a[min];
				if(out>m){
					out = m;
				}
				start+=1;
				end+=1;
			}
		}
		System.out.println(out);
	}
}