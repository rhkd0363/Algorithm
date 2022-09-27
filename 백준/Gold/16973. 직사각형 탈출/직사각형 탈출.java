import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, W, Sr, Sc, Fr, Fc, ans;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// N, M 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken()) - 1;
		Sc = Integer.parseInt(st.nextToken()) - 1;
		Fr = Integer.parseInt(st.nextToken()) - 1;
		Fc = Integer.parseInt(st.nextToken()) - 1;

		ans = -1;

		bfs();

		System.out.println(ans);
	}

	static boolean check = false;

	static void bfs() {
		queue.add(new int[] { Sr, Sc, 0 });

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int pos_x = pos[0];
			int pos_y = pos[1];

			if (pos_x == Fr && pos_y == Fc) {
				ans = pos[2];
				return;
			}

			// 좌우상하 순
			fo: for (int i = 0; i < 4; i++) {
				int nx = pos_x + dx[i];
				int ny = pos_y + dy[i];

				// 범위에 드는지, 이미 방문한 곳인지 확인
				if (nx >= N || ny >= M || nx < 0 || ny < 0 || visited[nx][ny])
					continue;

				// 좌
				if (i == 0) {
					for (int j = 0; j < H; j++) {
						if (map[nx + j][ny] == 1)
							continue fo;
					}
				}
				// 우
				else if (i == 1 && ny + W - 1 < M) {
					for (int j = 0; j < H; j++) {
						if (map[nx + j][ny + W - 1] == 1)
							continue fo;
					}
				}
				// 상
				else if (i == 2) {
					for (int j = 0; j < W; j++) {
						if (map[nx][ny + j] == 1)
							continue fo;
					}
				}
				// 하
				else if (i == 3 && nx + H - 1 < N) {
					for (int j = 0; j < W; j++) {
						if (map[nx + H - 1][ny + j] == 1)
							continue fo;
					}
				}
				else
					continue;

				visited[nx][ny] = true;
				queue.add(new int[] { nx, ny, pos[2] + 1 });
			}

		}

	}

}