import java.util.Scanner;

public class q{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for(int i =0; i<n; i++){
			a[i] = s.nextInt();
		}
		int start = 0;
		int end = n-1;
		int count_a = 1;
		int count_b = 1;
		int sum_a = a[start];
		int sum_b = a[end];
		if(n==1){
			System.out.println("1 0");
		}
		else if(n==2){
			System.out.println("1 1");
		}
		else{
			while(start!= end){
				// System.out.println(Integer.toString(start) + " " + Integer.toString(end) + Integer.toString(sum_a) + " " + Integer.toString(sum_b));
				if(sum_a<sum_b){
					start+=1;
					if(start==end){break;}
					else{
						sum_a += a[start];
						count_a++;
					}
				}
				else if(sum_a > sum_b){
					end-=1;
					if(start==end){break;}
					else{
						sum_b += a[end];
						count_b++;
					}
				}
				else if(sum_a == sum_b && start<end-2){
					start++;
					end--;
					count_a++;
					count_b++;
					sum_a+=a[start];
					sum_b+=a[end];
				}
				else if(sum_a==sum_b && start == end-2){
					sum_a+= a[start+1];
					count_a++;
					break;
				}
				else if(sum_a==sum_b && start==end-1){
					break;
				}
			}
			System.out.println(Integer.toString(count_a) + " " + Integer.toString(count_b));
		}
	}
}