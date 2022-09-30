import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, ans;
	static int[][] map;
	static int[] dy = { -1, 0, 1 }, dx = { 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행의 수
		M = Integer.parseInt(st.nextToken()); // 열의 수
		D = Integer.parseInt(st.nextToken()); // 궁수 공격 거리 제한

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;

		for(int i=0;i<M-2;i++) {
			for(int j=i+1;j<M-1;j++) {
				for(int k=j+1;k<M;k++) {
					ans = Math.max(ans, bfs(i,j,k));
				}
			}
		}
		System.out.println(ans);
	}

	static int bfs(int archerA, int archerB, int archerC) {
		int[] archer = { archerA, archerB, archerC };

		boolean[][] kill = new boolean[N][M];

		for (int i = N - 1; i >= 0; i--) {
			int[][] check = new int[3][2]; // 궁수들이 어느위치의 적을 죽였는지 확인할 배열
			for(int j=0;j<3;j++) {
				Arrays.fill(check[j], -1);	// -1 로 초기화
			}
			
			for (int j = 0; j < 3; j++) {
				Queue<int[]> queue = new LinkedList<int[]>();
				boolean[][] visited = new boolean[N][M];
				queue.add(new int[] { i, archer[j] });
				visited[i][archer[j]] = true;

				// BFS
				while (!queue.isEmpty()) {
					int[] curr = queue.poll();

					// 궁수의 공격 범위를 벗어났다면
					if (Math.abs(curr[0] - i) + Math.abs(curr[1] - archer[j]) > D-1) {
						continue;
					}

					// 적을 발견했으면 이미 죽인놈인지 확인
					if (map[curr[0]][curr[1]] == 1 && !kill[curr[0]][curr[1]]) {
						check[j][0] = curr[0];
						check[j][1] = curr[1];
						break;
					}
					// 밑으로는 안간다. 왼 위 오 순으로 진행하자
					for (int k = 0; k < 3; k++) {
						int nx = curr[0] + dx[k];
						int ny = curr[1] + dy[k];

						if (nx >= N || ny >= M || nx < 0 || ny < 0)
							continue;

						if (!visited[nx][ny]) {
							queue.add(new int[] { nx, ny });
							visited[nx][ny] = true;
						}
					}
				}
			}

			for (int j = 0; j < 3; j++) {
				if(check[j][0] != -1)
					kill[check[j][0]][check[j][1]] = true;
			}
		}
		
		int res = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(kill[i][j])
					res++;
			}
		}
		
		return res;
	}
}
