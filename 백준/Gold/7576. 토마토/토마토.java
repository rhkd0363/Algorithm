import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		int days = -1;
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					queue.add(new int[] { i, j });
				}
			}
		}


		while (!queue.isEmpty()) {
			days++;
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				int[] arr = queue.poll();
				for (int k = 0; k < 4; k++) {
					int nx = arr[0] + dx[k];
					int ny = arr[1] + dy[k];
					if (nx >= N || ny >= M || nx < 0 || ny < 0)
						continue;
					if (map[nx][ny] == 0) {
						map[nx][ny]++;
						queue.add(new int[] { nx, ny });
					}
				}
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					days = -1;
					break;
				}
			}
		}

		System.out.println(days);
	}
}
