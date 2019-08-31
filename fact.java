import java.util.Scanner;
public class fact{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double n = s.nextDouble();
		for(double i=1; i<=n; i*=2){
			System.out.println(i);
		}
	}
}