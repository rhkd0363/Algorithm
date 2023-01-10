import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int r;
	int c;
	int time;

	public Point(int r, int c, int time) {
		super();
		this.r = r;
		this.c = c;
		this.time = time;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];

		Queue<Point> fire = new LinkedList<>();
		Queue<Point> hoon = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String mapInfo = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = mapInfo.charAt(j);
				if (map[i][j] == 'J') {
					hoon.add(new Point(i, j, 1));
				} else if (map[i][j] == 'F') {
					fire.add(new Point(i, j, 0));
				}
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!hoon.isEmpty()) {
			int size = fire.size();
			for (int i = 0; i < size; i++) {
				Point curr = fire.poll();
				for (int j = 0; j < 4; j++) {
					int nr = curr.r + dr[j];
					int nc = curr.c + dc[j];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
						continue;
					}

					if (map[nr][nc] != '#' && map[nr][nc] != 'F') {
						map[nr][nc] = 'F';
						fire.add(new Point(nr, nc, 0));
					}
				}
			}

			size = hoon.size();
			for (int i = 0; i < size; i++) {
				Point curr = hoon.poll();
				for (int j = 0; j < 4; j++) {
					int nr = curr.r + dr[j];
					int nc = curr.c + dc[j];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
						System.out.println(curr.time);
						return;
					}

					if (map[nr][nc] != '#' && map[nr][nc] != 'F' && map[nr][nc] != 'J') {
						map[nr][nc] = 'J';
						hoon.add(new Point(nr, nc, curr.time + 1));
					}
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}
}
