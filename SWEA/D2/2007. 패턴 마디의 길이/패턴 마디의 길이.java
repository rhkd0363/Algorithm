import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tN = sc.nextInt();
		
		for(int i =1;i<=tN;i++) {
			String tC = sc.next();
			
			for (int j =1;j<tC.length();j++) {
				String a = tC.substring(0,j);
				String b =tC.substring(j,j+j);
				if( a.equals(b)) {
					System.out.println("#"+i+" "+b.length());
					break;
				}
			}
		}
	}
}
