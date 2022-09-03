import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N = 9;
	static int[][] map = new int[N][N];
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		tc: for (int tc = 1; tc <= T; tc++) {
			// 삽입~
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				// 가로 검사~
				check = new boolean[N + 1];
				for (int j = 0; j < N; j++) {
					if (check[map[i][j]]) {
						System.out.println("#" + tc + " 0");
						continue tc;
					}
					check[map[i][j]] = true;
				}
				// 세로 검사~
				check = new boolean[N + 1];
				for (int j = 0; j < N; j++) {
					if (check[map[j][i]]) {
						System.out.println("#" + tc + " 0");
						continue tc;
					}
					check[map[j][i]] = true;
				}
			}

			// 작은 네모 검사~
			for (int n = 0; n < N; n += 3) {
				for (int m = 0; m < N; m += 3) {
					check = new boolean[N + 1]; // 위치 중요~
					for (int i = n; i < n + 3; i++) {
						for (int j = m; j < m + 3; j++) {
							if (check[map[j][i]]) {
								System.out.println("#" + tc + " 0");
								continue tc;
							}
							check[map[j][i]] = true;
						}
					}
				}
			}
			System.out.println("#" + tc + " 1");

		}
	}
}
