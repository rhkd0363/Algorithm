import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static Queue<point> queue = new LinkedList<>();
	static int N, K, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			int max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}

			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						visited = new boolean[N][N];
						bfs(i, j);
					}
				}
			}

			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}

		System.out.println(sb);
	}
	static class point{
		int x;
		int y;
		int value;
		int check;
		int count;
		List<int[]> list;
		
		public point(int x, int y, int value, int check, int count, List<int[]> list) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.check = check;
			this.count = count;
			this.list = list;
		}
	}
	static void bfs(int x, int y) {
		List<int[]> list = new ArrayList<>();
		queue.offer(new point(x,y,map[x][y],0,1, list));

		while (!queue.isEmpty()) {
			point pos = queue.poll();
			
			ans = Math.max(ans, pos.count);

			out : for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];

				if (nx >= N || ny >= N || nx < 0 || ny < 0)
					continue;
				
				// 현재 위치보다 높이가 낮다면
				if (map[nx][ny] < pos.value) {
					List<int[]> tmp = new ArrayList<>(pos.list);
					tmp.add(new int[] {pos.x,pos.y});
					queue.offer(new point(nx,ny,map[nx][ny], pos.check, pos.count +1, tmp));
				}
				// 높이가 같거나 높다면
				else {
					// 아직 안 깍
					if (pos.check == 0) {
						for(int j=0;j<pos.list.size();j++) {
							if(nx == pos.list.get(j)[0]&& ny==pos.list.get(j)[1])
								continue out;
						}
						for (int k = K; k >= 1; k--) {
							if ((map[nx][ny] - k) < pos.value) {
								List<int[]> tmp = new ArrayList<>(pos.list);
								tmp.add(new int[] {pos.x,pos.y});
								queue.offer(new point(nx,ny,map[nx][ny] - k, k, pos.count +1, tmp));
							}

						}
					}
				}

			}

		}

	}
}
