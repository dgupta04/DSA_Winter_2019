import java.util.Scanner;

public class everything{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = s.nextInt();
		}
		int i= 0;
		while(i<n-1){
			while(a[i]<a[i+1] && i<n-1){
					System.out.print(Integer.toString(a[i]) + " ");
					i++;
			}
			if(i==n-1){
				if(a[i]>a[i-1]){
					System.out.print(Integer.toString(a[i]) + " ");
				}
				else{
					System.out.println();
					System.out.print(a[i]);
				}
			}
			i++;
			System.out.println();
		}
		
}}		
