import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int mi = 0;
			int ho = 0;
			int[] iArr = new int[4];
			
			for(int j = 0;j<4;j+=2) {
				iArr[j] = sc.nextInt();
				iArr[j+1] = sc.nextInt();
			}
			mi = iArr[1]+iArr[3];
			ho = iArr[0]+iArr[2];
			if(mi>59) {
				mi = mi-60;
				ho = ho+1;
			}
			if(ho>12) {
				ho = ho-12;
			}
			System.out.println("#"+i+" "+ho+" "+mi);
		}
	}
}
