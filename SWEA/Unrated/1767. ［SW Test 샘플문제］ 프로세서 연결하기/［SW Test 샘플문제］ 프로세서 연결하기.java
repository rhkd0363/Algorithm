import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, core;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];

			core = 0;
			maxCore = 0;

			ans = 0;
			boolean[][] check = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) { //벽붙은거 제외
							check[i][j] = true;
							continue;
						}
						core++;
					}
				}
			}

			dfs(check, 0, 0, 0);

			sb.append("#" + t + " " + ans).append('\n');
		}
		System.out.println(sb);
	}

	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int maxCore;
	static int ans;

	static void dfs(boolean[][] check, int idx, int length, int conn) {
		if (idx == core) { // 모든 코어 확인했다면
			if (conn > maxCore) { // 연결된 코어수가 현재 결과보다 많다면
				maxCore = conn;
				ans = length;
			} else if (conn == maxCore) { // 연결된 코어수가 같다면
				ans = Math.min(ans, length); // 더 적은 전선 수가 답
			}
			return;
		}

		// idx랑 코어수로 비교
		if (core - idx + conn < maxCore) // 백트래킹
			return;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !check[i][j]) { // 코어가 있고 방문하지 않았다면
					check[i][j] = true;

					for (int k = 0; k < 4; k++) {
						boolean[][] copyCheck = new boolean[N][N];

						for (int l = 0; l < N; l++)
							copyCheck[l] = check[l].clone();

						setLine(i, j, 0, k, conn, copyCheck, idx, length);
					}
				}
			}
		}
	}

	static void setLine(int nx, int ny, int nowLen, int k, int conn, boolean[][] check, int idx, int length) {
		while (true) {
			nx += dx[k];
			ny += dy[k];

			if (nx >= N || ny >= N || nx < 0 || ny < 0) {// 벽과 만나는 경우
				conn++;
				break;
			}

			if (check[nx][ny] == true || map[nx][ny] == 1) { // 전선이나 코어와 만나는 경우
				nowLen = 0;
				break;
			}

			check[nx][ny] = true; // 전선이 지나는 부분을 true로 바꿔주자

			nowLen++; // 전선 길이도 늘려주자
		}
		dfs(check, idx + 1, length + nowLen, conn); // 다음 코어로 넘어가서 확인하자
	}
}