import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, startX, startY, ans;
	static char[][] map;
	static boolean[][][] visited;
	static Queue<minsik> queue = new LinkedList<>();
	static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };

	static class minsik {
		int x;
		int y;
		int count;
		int key;

		public minsik(int x, int y, int count, int key) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// N, M 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][64];

		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = data.charAt(j);

				if (map[i][j] == '0') {
					startX = i;
					startY = j;
					map[i][j] = '.';
				}

			}
		}

		ans = -1;

		bfs();

		System.out.println(ans);
	}

	static void bfs() {
		queue.offer(new minsik(startX, startY, 0, 0));
		// X좌표,Y좌표,키의 개수
		visited[startX][startY][0] = true;

		while (!queue.isEmpty()) {
			minsik pos = queue.poll();
			
			if (map[pos.x][pos.y] == '1') {
				ans = pos.count;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];

				if (nx >= N || ny >= M || nx < 0 || ny < 0)
					continue;

				switch (map[nx][ny]) {
				case '#':
					break;
				case 'a':case 'b':case 'c':case 'd':case 'e':case 'f':
					if (!visited[nx][ny][pos.key]) {
						// 같은 키 확인? 0이 아니면 키를 가지고 있는 것
						if ((pos.key & (1 << (map[nx][ny] - 'a'))) == 0) {
							visited[nx][ny][pos.key | (1 << (map[nx][ny] - 'a'))] = true;
							queue.offer(new minsik(nx, ny, pos.count + 1, pos.key | (1 << (map[nx][ny] - 'a'))));
						} else {
							visited[nx][ny][pos.key] = true;
							queue.offer(new minsik(nx, ny, pos.count + 1, pos.key));
						}
					}
					break;
				case 'A':case 'B':case 'C':case 'D':case 'E':case 'F':
					// 키를 가지고 있으면
					if (!visited[nx][ny][pos.key] && (pos.key & (1 << (map[nx][ny] - 'A'))) != 0) {
						visited[nx][ny][pos.key] = true;
						queue.offer(new minsik(nx, ny, pos.count + 1, pos.key));
					}
					break;
				default:
					if (!visited[nx][ny][pos.key]) {
						visited[nx][ny][pos.key] = true;
						queue.offer(new minsik(nx, ny, pos.count + 1, pos.key));
					}
					break;
				}

			}

		}
	}
}
