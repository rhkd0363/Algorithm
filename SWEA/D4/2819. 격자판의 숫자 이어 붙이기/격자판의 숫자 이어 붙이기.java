import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static int[][] arr = new int[4][4];
	static int N = 4;
	static HashSet<String> hashSet;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			hashSet = new HashSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					move(i, j, "", 0);
				}
			}
			System.out.println("#"+t+" "+hashSet.size());
		}

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void move(int r, int c, String num, int cnt) {
		if (cnt == 7) {
			hashSet.add(num);
			return;
		}
		
		num += arr[r][c];
		cnt++;
		if (r + dx[0] >= 0 && c + dy[0] >= 0 && r + dx[0] < N && c + dy[0] < N) {
			move(r + dx[0], c + dy[0], num, cnt);
		}
		if (r + dx[1] >= 0 && c + dy[1] >= 0 && r + dx[1] < N && c + dy[1] < N) {
			move(r + dx[1], c + dy[1], num, cnt);
		}
		if (r + dx[2] >= 0 && c + dy[2] >= 0 && r + dx[2] < N && c + dy[2] < N) {
			move(r + dx[2], c + dy[2], num, cnt);
		}
		if (r + dx[3] >= 0 && c + dy[3] >= 0 && r + dx[3] < N && c + dy[3] < N) {
			move(r + dx[3], c + dy[3], num, cnt);
		}
	}
}
