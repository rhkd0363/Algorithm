import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] memo;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(st.nextToken()); // 가로

		map = new int[M][N];
		memo = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1;
			}
		} // 맵 정보 입력

		
		int ans = dfs(0, 0);
		
		System.out.println(ans);
	}

	static int dfs(int r, int c) {
		if (r == M - 1 && c == N - 1) {
			return 1;
		}

		if (memo[r][c] != -1)
			return memo[r][c];

		int result = 0;

		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];

			if (nr >= M || nc >= N || nr < 0 || nc < 0 || map[nr][nc] >= map[r][c])
				continue;

			result += dfs(nr, nc);
		}

		memo[r][c] = result;

		return result;
	}
}