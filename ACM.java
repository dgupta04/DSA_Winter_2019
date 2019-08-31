import java.util.Scanner;

public class ACM{
	public static int countmatch(String qMatch, String[] names){
		int l = qMatch.length();
		int count = 0;
		for(int i=0; i<names.length; i++){
			boolean m = true;
			if(l <= names[i].length()){
				for(int j=0; j<l; j++){
					m = m && (qMatch.charAt(j) == (names[i].charAt(j)));
				}
			}
			else{
				continue;
			}
			if(m){
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		String[] names = new String[n];
		String x = s.nextLine();
		int[] par = new int[n];
		for(int i=0; i<n; i++){
			String ip = s.nextLine();
			String[] ipSpl = ip.trim().split(" ");
			String a = ipSpl[0];
			int p = Integer.parseInt(ipSpl[1]);
			par[i] = p;
			if(i==0){
				names[i] = a;
			}
			else{
				// System.out.println(par[i-1] == p);
				if(par[i-1] != p){
					// int currPar = i-1;
					// while(par[currPar] == p){
					// 	currPar--;
					// }
					String newName = a + names[i-1];
					names[i] = newName;
				}
				else{
					int currPar = i-1;
					while(par[currPar] == p){
						currPar--;
					}
					String newName = a + names[currPar];
					names[i] = newName;	
				}
			}
		}
		String[] query = new String[k];
		int[] count = new int[n];
		for(int i=0; i<k; i++){
			String q = s.nextLine();
			query[i] = q;
		}
		for(int i=0; i<k; i++){
			System.out.println(countmatch(query[i], names));
		}
	}
}