import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
//			우 하 좌 상
//			int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
			int[][] dxdy = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
			int N = 1, x = 0, y = 0, idx = 0;
			for (; N <= n * n;) {
				int X = x + dxdy[idx][0];
				int Y = y + dxdy[idx][1];
				if (X < 0 || Y < 0 || X >= n || Y >= n || arr[X][Y] != 0) {
					idx = (idx + 1) % 4;
					X = x + dxdy[idx][0];
					Y = y + dxdy[idx][1];
				}
				arr[x][y] = N++;
				x = X;
				y = Y;
			}
			System.out.println("#"+t);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}

		}
	}
}