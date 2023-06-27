import java.io.*;
import java.util.*;

public class Main {
	static class Hero {
		int x;
		int y;
		int time;
		boolean gram;

		public Hero(int x, int y, int time, boolean gram) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.gram = gram;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		boolean[][] visited = new boolean[N][M];
		boolean[][] visitedGram = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Hero> queue = new LinkedList<>();

		queue.add(new Hero(0, 0, 0, false));

		int answer = 0;

		int[][] dxdy = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		while (!queue.isEmpty()) {
			Hero curr = queue.poll();

			if (curr.time > T || (curr.x == N - 1 && curr.y == M - 1)) {
				answer = curr.time;
				break;
			}

			if (!curr.gram) {
				if (visited[curr.x][curr.y])
					continue;

				visited[curr.x][curr.y] = true;

				for (int i = 0; i < 4; i++) {
					int nx = curr.x + dxdy[i][0];
					int ny = curr.y + dxdy[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 1)
						continue;

					if (map[nx][ny] == 2) {
						queue.add(new Hero(nx, ny, curr.time + 1, true));
						visited[nx][ny] = true;
					} else {
						queue.add(new Hero(nx, ny, curr.time + 1, false));
					}
				}
			} else {
				if (visitedGram[curr.x][curr.y])
					continue;

				visitedGram[curr.x][curr.y] = true;

				for (int i = 0; i < 4; i++) {
					int nx = curr.x + dxdy[i][0];
					int ny = curr.y + dxdy[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;

					queue.add(new Hero(nx, ny, curr.time + 1, true));
				}
			}
		}
		
		System.out.println(T >= answer && answer != 0 ? answer : "Fail");

	}
}
