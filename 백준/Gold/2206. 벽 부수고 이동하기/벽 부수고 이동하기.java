import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count;
	static int[][] map;
	static boolean[][][] visited;
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
		visited = new boolean[N][M][2];

		// map 정보 입력
		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = data.charAt(j) - '0';
			}
		}

		int result = Integer.MAX_VALUE;

		count = 0;

		if (bfs())
			result = Math.min(result, count);

		if (result != Integer.MAX_VALUE)
			System.out.println(result);
		else
			System.out.println(-1);
	}

	static boolean bfs() {
		queue.add(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] pos = queue.poll();

				if (pos[0] == N - 1 && pos[1] == M - 1)
					return true;

				for (int j = 0; j < 4; j++) {
					int nx = pos[0] + dx[j];
					int ny = pos[1] + dy[j];

					if (nx >= N || ny >= M || nx < 0 || ny < 0)
						continue;

					
					// 벽을 한개도 안 부쉈다면
					if (pos[2] == 0) {
						// 벽을 부숨
						if (!visited[nx][ny][0] && map[nx][ny] == 1) {
							visited[nx][ny][1] = true;
							queue.add(new int[] { nx, ny, 1 });
						} else if (!visited[nx][ny][0] && map[nx][ny] == 0) {
							visited[nx][ny][0] = true;
							queue.add(new int[] { nx, ny, 0 });
						}
					} else {
						if (!visited[nx][ny][1] && map[nx][ny] == 0) {
							visited[nx][ny][1] = true;
							queue.add(new int[] { nx, ny, 1 });
						}
					}
					
					
				}
			}
		}

		return false;
	}
	
}