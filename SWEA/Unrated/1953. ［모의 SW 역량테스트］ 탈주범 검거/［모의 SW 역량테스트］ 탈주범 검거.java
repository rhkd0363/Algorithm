import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

/*
 * 탈주범이 있을 수 있는 위치의 개수를 구하는 문제
 * 
 * 탈주범은 한 시간 뒤 맨홀 뚜껑에 들어갔다.
 * 
 * 탈주범은 시간당 1의 거리를 움직인다.
 */

public class Solution {
	static int[][] map;
	static int N, M, R, C, L;

	static int[][] dr = { { -1, 1, 0, 0 }, { -1, 1, 0, 0 }, { 0, 0, 0, 0 }, { -1, 0, 0, 0 }, { 0, 1, 0, 0 },
			{ 0, 1, 0, 0 }, { -1, 0, 0, 0 } };
	static int[][] dc = { { 0, 0, -1, 1 }, { 0, 0, 0, 0 }, { 0, 0, -1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 },
			{ 0, 0, -1, 0 }, { 0, 0, -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 지하터널 세로크기
			M = Integer.parseInt(st.nextToken()); // 지하터널 가로크기
			R = Integer.parseInt(st.nextToken()); // 맨홀뚜껑 세로좌표
			C = Integer.parseInt(st.nextToken()); // 맨홀뚜껑 가로좌표
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간

			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 지하터널 파이프 정보 입력

			sb.append('#').append(t).append(' ').append(bfs()).append('\n');
		}
		
		System.out.println(sb);

	}

	static int bfs() {
		boolean[][] checkMap = new boolean[N][M];

		// 현재좌표, 내가 어디서 왔는지 좌표(내가어디서왔는지 거기랑 연결되어있는지 확인용도 연결되어있다면 현재 위치 true)
		Queue<int[]> queue = new LinkedList<int[]>();

		checkMap[R][C] = true;

		for (int i = 0; i < 4; i++) {
			int nr = R + dr[map[R][C]-1][i];
			int nc = C + dc[map[R][C]-1][i];

			if (nr >= N || nc >= M || nr < 0 || nc < 0)
				continue;

			queue.add(new int[] { nr, nc, R, C });
		}

		int time = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			if (L == time++)
				break;
			out: for (int i = 0; i < size; i++) {
				int[] curr = queue.poll();
				int nowR = curr[0];
				int nowC = curr[1];
				int prevR = curr[2];
				int prevC = curr[3];

				if (checkMap[nowR][nowC] || map[nowR][nowC] == 0) // 이미방문했거나 파이프가아니라면 넘어가자
					continue;

				for (int j = 0; j < 4; j++) {
					int nr = nowR + dr[map[nowR][nowC]-1][j];
					int nc = nowC + dc[map[nowR][nowC]-1][j];

					if (nr >= N || nc >= M || nr < 0 || nc < 0)
						continue;

					if (nr == prevR && nc == prevC) {
						checkMap[nowR][nowC] = true;
						break;
					}

					if (j == 3) // 이전 좌표와 연결되어있지 않으면 다음 큐로 넘어가자
						continue out;
				}

				for (int j = 0; j < 4; j++) {
					int nr = nowR + dr[map[nowR][nowC]-1][j];
					int nc = nowC + dc[map[nowR][nowC]-1][j];

					if (nr >= N || nc >= M || nr < 0 || nc < 0)
						continue;

					if (!checkMap[nr][nc]) { // 아직 방문 안했다면~
						queue.add(new int[] { nr, nc, nowR, nowC });
					}
				}
				
			}
		}
		
		int res = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(checkMap[i][j])
					res++;
			}
		}
		
		return res;

	}

}