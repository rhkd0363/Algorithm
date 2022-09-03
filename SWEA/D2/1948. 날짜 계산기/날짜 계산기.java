import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] day = {31,28,31,30,31,30,31,31,30,31,30,31};
		int tN = sc.nextInt(); 
		
		for(int i=1; i<=tN; i++) {
			int sMonth = sc.nextInt();
			int sDay = sc.nextInt();
			int eMonth = sc.nextInt();
			int eDay = sc.nextInt();
			
			int sumDay =0;
			for(int m = sMonth-1; m<eMonth-1;m++) {
				sumDay += day[m];
			}
			sumDay= sumDay-sDay+eDay+1;
			
			System.out.println("#"+i+" "+sumDay);
		}
	}
}
