import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] iArr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					iArr[i][j] = sc.nextInt();
				}
			}
			System.out.println("#"+t);
			for (int num = 0; num < N; num++) {
				for (int i = N - 1; i >= 0; i--) {
					System.out.print(iArr[i][num]);
				}
				System.out.print(" ");
				for (int i = N - 1; i >= 0; i--) {
					int j = N - num - 1;
					System.out.print(iArr[j][i]);
				}
				System.out.print(" ");
				for (int i = 0; i < N; i++) {
					int j = N - num - 1;
					System.out.print(iArr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
