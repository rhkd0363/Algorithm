import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int tN = sc.nextInt();
			int[] chkArr = new int[101];
			// 입력
			for (int i = 0; i < 1000; i++) {
				chkArr[sc.nextInt()]++;
			}
			int max = Integer.MIN_VALUE;
			int res = 0;
			for (int i = 0; i < chkArr.length; i++) {
				if (max < chkArr[i]) {
					max = chkArr[i];
					res = i;
				} else if (max == chkArr[i]) {
					res = i;
				}
			}
			System.out.println("#"+tN+" "+res);
		}
	}
}
