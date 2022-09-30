import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 17472 다리 만들기2
 * 
 * 다리는 세로 또는 세로방향으로 밖에 못 만든다.
 * 다리의 길이는 2 이상이어야 한다.
 */

public class Main {
	static int N, M, landNum;
	static int[][] map;
	static int[][] landData;
	static boolean[][] visited;
	static List<Land>[] adjList;
	static int[] dx = { -1,1, 0, 0}, dy = { 0, 0, -1, 1};
	
	static class Land implements Comparable<Land>{
		int end; // 도착 섬 번호
		int dist; // 섬까지의 거리

		public Land(int end, int dist) {
			super();
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(Land o) {
			return this.dist-o.dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행 길이 입력
		M = Integer.parseInt(st.nextToken()); // 열 길이 입력
		
		// 섬 데이터를 입력 받는다.
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬의 번호를 입력한 배열
		landData = new int[N][M];
		
		// 섬의 방문 여부를 확인하기 위한 배열
		visited = new boolean[N][M];

		// 섬의 수를 담을 변수
		landNum = 1;

		// 섬끼리 구분 짓는다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 섬을 찾으면 섬의 범위에 섬의 번호를 매긴다.
				if (map[i][j] == 1 && !visited[i][j]) {
					
					// BFS
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { i, j });
					landData[i][j] = landNum;
					visited[i][j] = true;

					// Queue 가 빌 때까지 반복
					while (!queue.isEmpty()) {
						int[] curr = queue.poll();

						for (int k = 0; k < 4; k++) {
							int nx = curr[0] + dx[k];
							int ny = curr[1] + dy[k];

							if (nx >= N || ny >= M || nx < 0 || ny < 0)
								continue;

							if (!visited[nx][ny] && map[nx][ny] == 1) {
								landData[nx][ny] = landNum;
								visited[nx][ny] = true;
								queue.add(new int[] { nx, ny });
							}
						}
					}
					// 섬의 번호를 입력했으면 다음 섬을 위해 값을 증가시킨다.
					landNum++;
				}
			}
		}
		
		// 섬끼리의 연결 정보를 담을 인접 리스트 생성 및 초기화
		adjList = new ArrayList[landNum];
		
		for(int i=0;i<adjList.length;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 섬의 거리를 입력하기 위한 배열 선언 및 초기화
		int[] dist = new int[landNum];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 섬 사이의 거리를 인접 리스트에 입력한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//
				if(landData[i][j] != 0) {
					for(int k=0;k<4;k++) {
						int nx = i;
						int ny = j;
						int cnt = 0; // 다리의 길이
						
						while(true) { // 범위 안 일동안 반복
							nx = nx + dx[k];
							ny = ny + dy[k];
							
							//범위 밖이면 멈춘다.
							if(nx >= N || ny >= M || nx < 0 || ny < 0)
								break;
							
							//같은 섬이면 멈춘다.
							if(landData[nx][ny] == landData[i][j])
								break;
							
							// 진행하다가 바다가 아니고, 다리의 길이가 2 이상이라면 인접 리스트에 넣고 다음 방향으로 넘어간다.
							if(landData[nx][ny] != 0) {
								if(cnt >= 2)
									adjList[landData[i][j]].add(new Land(landData[nx][ny], cnt));
								break;
							}
							
							// 다리의 길이
							cnt++;
						}
					}
				}
			}
		}// 섬 간의 연결 정보 구하기 완료
		
		
		boolean[] check = new boolean[landNum]; // Prim 하면서 방문 여부 확인~
		
		// Prim 진행
		PriorityQueue<Land> pq = new PriorityQueue<>();
		pq.add(new Land(1, 0));
		dist[1] = 0;
		check[1] = true;
		
		while(!pq.isEmpty()) {
			Land curr = pq.poll();
			
			check[curr.end] = true;
			
			for(Land land: adjList[curr.end]) {
				if(!check[land.end] && dist[land.end] > land.dist) {
					dist[land.end] = land.dist;
					pq.add(new Land(land.end, dist[land.end]));
				}
			}
		}
		
		
		double ans = 0;
		
		for(int i = 1 ;i < dist.length;i++) {
			ans += dist[i];
		}
		
		// 답 출력
		if(ans >= Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println((int)ans);
		}

	}

}
