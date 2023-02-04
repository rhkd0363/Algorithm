import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][n + 1];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = -1; // 전
			arr[y][x] = 1; // 후
		}

		for (int i = 1; i <= n; i++) { // 경
			for (int j = 1; j <= n; j++) { // 출
				for (int l = 1; l <= n; l++) { // 도
					if (arr[j][i] == -1 && arr[i][l] == -1) {
						arr[j][l] = -1; // 전
						arr[l][j] = 1; // 후
					}
				}
			}
		}

		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x < 1 || y < 1 || x > n || y > n) { // 범위 벗어나는거
				System.out.println(0);
			} else {
				System.out.println(arr[x][y]);
			}
		}
	}
}