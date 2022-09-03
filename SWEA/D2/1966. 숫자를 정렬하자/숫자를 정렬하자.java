import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1;t<=T;t++) {
			int N = sc.nextInt();
			int[] iArr = new int[N];
			
			for(int i =0;i<iArr.length;i++) {
				iArr[i] = sc.nextInt();
				
			}
			Arrays.sort(iArr);
//			if(iArr[0] == 0) {
//				int[] tArr = new int[iArr.length];
//				for(int i =0;i<iArr.length-1;i++) {
//					tArr[i] = iArr[i+1];
//				}
//				tArr[iArr.length-1] = 0;
//				iArr = tArr;
//			}
			System.out.print("#"+t);
			for(int i=0;i<iArr.length;i++) {
				System.out.print(" "+iArr[i]);				
			}
			System.out.println();
		}
	}
}
