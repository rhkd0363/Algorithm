import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, ans;
	static int[][] map, res;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			res = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String mapInfo = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = mapInfo.charAt(j) - '0';
				}
			}
			ans = Integer.MAX_VALUE;
			bfs(0, 0);

			sb.append("#" + t + " " + ans).append('\n');
		}
		System.out.println(sb);
	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(x, y));
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			Point pos = queue.poll();

			if (pos.x == N - 1 && pos.y == N - 1) {
				ans = Math.min(ans, res[N - 1][N - 1]);
			}

			if (ans <= res[pos.x][pos.y])
				continue;

			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];

				if (nx >= N || ny >= N || nx < 0 || ny < 0) {
					continue;
				}

				if (!visited[nx][ny] || res[nx][ny] > res[pos.x][pos.y]+map[nx][ny]) {
					res[nx][ny] = res[pos.x][pos.y] + map[nx][ny];
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}

		}

	}
}
