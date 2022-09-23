import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H;
	static int[][][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		int[] dx = { -1, 1, 0, 0, 0, 0 };
		int[] dy = { 0, 0, -1, 1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, -1, 1 };

		int days = -1;
		Queue<int[]> queue = new LinkedList<>();

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 1) {
						queue.add(new int[] { h, i, j });
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			days++;
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				int[] arr = queue.poll();
				for (int k = 0; k < 6; k++) {
					int nz = arr[0] + dz[k];
					int nx = arr[1] + dx[k];
					int ny = arr[2] + dy[k];
					if (nz >= H || nx >= N || ny >= M || nx < 0 || ny < 0 || nz < 0)
						continue;
					if (map[nz][nx][ny] == 0) {
						map[nz][nx][ny]++;
						queue.add(new int[] { nz, nx, ny });
					}
				}
			}

		}

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 0) {
						days = -1;
						break;
					}
				}
			}
		}

		System.out.println(days);
	}
}
