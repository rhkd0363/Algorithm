import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K;
	static Cell[][] map;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	static class Cell {
		int time; // 시간이 주어지면 시간만큼 비활성이다가 시간만큼 활성화되고 죽는다.
		int activeTime;
		boolean active;
		boolean life;

		public Cell(int time, int activetime, boolean active, boolean life) {
			this.time = time;
			this.activeTime = activetime;
			this.active = active;
			this.life = life;
		}

		@Override
		public String toString() {
			return "   " + time;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new Cell[N + K][M + K];

			Queue<int[]> queue = new LinkedList<>();
			
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[2] - o1[2]; //내림차순
				}
			});

			for (int i = K / 2; i < K / 2 + N; i++) { // 맵에 정보입력
				st = new StringTokenizer(br.readLine());
				for (int j = K / 2; j < K / 2 + M; j++) {
					int time = Integer.parseInt(st.nextToken());
					if (time > 0) {
						map[i][j] = new Cell(time, 0, false, true);
						queue.add(new int[] { i, j, map[i][j].time });
					}
				}
			}

			int cnt = 0;

			while (true) {
				if (cnt++ == K)
					break;
				while(!queue.isEmpty())
					pq.add(queue.poll());
//				System.out.println(queue.size());
				while(!pq.isEmpty()) {
					int[] curr = pq.poll();
					int x = curr[0];
					int y = curr[1];

					if (!map[x][y].life)
						continue;

					if (map[x][y].active) {
						if (map[x][y].activeTime == 0) {
							for (int j = 0; j < 4; j++) {
								int nx = x + dx[j];
								int ny = y + dy[j];

								if (map[nx][ny] == null) {
									map[nx][ny] = new Cell(map[x][y].time, 0, false, true);
									queue.add(new int[] { nx, ny, map[nx][ny].time });
								}
							}
						}

						map[x][y].activeTime++;

						if (map[x][y].activeTime == map[x][y].time) {
							map[x][y].life = false;
							continue;
						}

						queue.add(new int[] { x, y ,map[x][y].time});

					}

					else {// 비활성
						map[x][y].activeTime++;

						if (map[x][y].activeTime == map[x][y].time) {
							map[x][y].active = true;
							map[x][y].activeTime = 0;
						}

						queue.add(new int[] { x, y, map[x][y].time});
					}

				}
			}

			int res = 0;

			for (int i = 0; i < N + K; i++) {
				for (int j = 0; j < M + K; j++) {
					if (map[i][j] != null && map[i][j].life)
						res++;
				}
			}

			sb.append('#').append(t).append(' ').append(res).append('\n');
		}
		System.out.println(sb);
	}
}
