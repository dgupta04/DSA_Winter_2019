import java.util.Scanner;    


public class ClassNew {
	public static void Pattern(int n)
	{

		for(int i = 1; i<=n ; i++){
			for(int j = 1; j<= 5-i; j++)
			{
				System.out.print(" ");
			}
			for(int k = 1; k<=i; k++)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt(); 
		Pattern(inp);
	}
}