import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int endPoint = 0;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2)
						endPoint = j;
				}
			}
			int[] dx = { -1, 0, 0 }, dy = { 0, -1, 1 };
			int x = 99, y = endPoint, tx = 0, ty = 0;
			while (x > 0) {
				for (int d = 0; d < 3; d++) {
					int nx = x + dx[d], ny = y + dy[d];
					if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100) {
						continue;
					}
					else {
						if (arr[nx][ny] == 1 && !(nx == tx && ny == ty)) {
							tx = x;
							ty = y;
							x = nx;
							y = ny;
						}
					}
				}
			}
			System.out.println("#" + t + " " + y);
		}
	}
}
