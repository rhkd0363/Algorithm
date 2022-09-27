import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, count;
	static int[][] map;
	static boolean[][][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		// N, M 입력
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][K + 1];

		// map 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = Integer.MAX_VALUE;

		count = 0;

		if (bfs())
			result = Math.min(result, count);

		if (result != Integer.MAX_VALUE)
			System.out.println(result-1);
		else
			System.out.println(-1);
	}

	static int[] horseX = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] horseY = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static boolean bfs() {
		queue.add(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] pos = queue.poll();
				int jumpCnt = pos[2];

				if (pos[0] == N - 1 && pos[1] == M - 1)
					return true;

				// 아직 말처럼 뛸 수 있다면
				if (jumpCnt < K) {
					for (int j = 0; j < 8; j++) {
						int nx = pos[0] + horseX[j];
						int ny = pos[1] + horseY[j];

						if (nx >= N || ny >= M || nx < 0 || ny < 0)
							continue;

						// 점프뛴 횟수로 방문배열 체크 안되었다면
						if (map[nx][ny] == 0 && !visited[nx][ny][jumpCnt + 1]) {
							visited[nx][ny][jumpCnt + 1] = true;
							queue.add(new int[] { nx, ny, jumpCnt + 1 });
						}
					}
				}

				// 인접 칸
				for (int j = 0; j < 4; j++) {
					int nx = pos[0] + dx[j];
					int ny = pos[1] + dy[j];

					if (nx >= N || ny >= M || nx < 0 || ny < 0)
						continue;

					if (!visited[nx][ny][jumpCnt] && map[nx][ny] == 0) {
						visited[nx][ny][jumpCnt] = true;
						queue.add(new int[] { nx, ny, jumpCnt });
					}

				}
			}
		}

		return false;
	}

}