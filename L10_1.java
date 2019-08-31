import java.util.Scanner;
import java.util.ArrayList;

public class L10_1{
	public static int indFromStr(String time){
		int ind = 0;
		String[] t = time.trim().split(" ");
		String[] a = t[0].trim().split(":");
		if(t[1].equals("pm")){
			ind = 720;
			if(Integer.parseInt(a[0])==12){
					ind +=Integer.parseInt(a[1]);
			}
			else{
				ind += ((Integer.parseInt(a[0])*60)) + Integer.parseInt(a[1]);
			}			
		}
		else{
			if(Integer.parseInt(a[0])==12){
					ind +=Integer.parseInt(a[1]);
			}
			else{
				ind += ((Integer.parseInt(a[0])*60)) + Integer.parseInt(a[1]);
			}
		}
		return ind;
	}
	public static int BFSTime(String start, String end, int[] distance, boolean[] visi)
	{
		for(int i=0; i<1440; i++){
			distance[i] = Integer.MAX_VALUE;
			visi[i] = false;
		}
		distance[indFromStr(start)] = 0;
		visi[indFromStr(start)] = true;
		ArrayList<Integer> q = new ArrayList<Integer>();
		q.add(indFromStr(start));
		while(!(q.isEmpty())){
			int c = q.remove(0);
			int k = c;
			int n1,n2,n3,n4,n5;
			n1 = k+60;
			if(n1>=1440){
				n1-=1440;
			}
			n2 = k-60;
			if(n2<0){
				n2+=1440;
			}
			n3 = k+1;
			if(n3==1440){
				n3 = 0;
			}
			n4 = k-1;
			if(n4==-1){
				n4 = 1439;
			}
			n5 = k + 720;
			if(n5>=1440){
				n5-= 1440;
			}
			int[] allNeighbours = {n1,n2,n3,n4,n5};
			for(int i=0; i<allNeighbours.length; i++){
				if(visi[allNeighbours[i]] == false){
					q.add(allNeighbours[i]);
					visi[allNeighbours[i]] = true;
					distance[allNeighbours[i]] = distance[c]+1;
					if(indFromStr(end) == allNeighbours[i]){
						return distance[c]+1;
					} 
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner Sc = new Scanner(System.in);
		int n = Sc.nextInt();
		int[] distance = new int[1440];
		boolean[] visi = new boolean[1440];
		String a = Sc.nextLine();
		String[][] allTests = new String[n][2];
		for(int i=0; i<n; i++){
			String timeStart = Sc.nextLine();  
			String timeEnd = Sc.nextLine();
			String[] addTime = {timeStart, timeEnd};
			allTests[i] = addTime;
		}
		for(int i=0; i<n; i++){
			System.out.println(BFSTime(allTests[i][0], allTests[i][1], distance, visi));
		}
	}
}