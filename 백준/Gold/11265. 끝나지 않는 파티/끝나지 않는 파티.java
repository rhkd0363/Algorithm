import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 파티장 별 각 최단경로(다익스트라 알고리즘)
public class Main {
	static final int INF = Integer.MAX_VALUE;

	static class Node implements Comparable<Node> {
		int end;
		int time;

		public Node(int end, int time) {
			super();
			this.end = end;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}

		@Override
		public String toString() {
			return "Node [end=" + end + ", time=" + time + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 파티장 크기(수)
		int M = Integer.parseInt(st.nextToken()); // 손님의 수

		List<Node>[] adjList = new ArrayList[N + 1]; // 파티장 간 직접 이동 소요 시간 인접리스트

		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				if (i == j) {
					st.nextToken();
					continue;
				}
				adjList[i].add(new Node(j, Integer.parseInt(st.nextToken())));
			}
		}

		int[][] time = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			Arrays.fill(time[i], INF);
		}

		// 다익스트라
		for (int i = 1; i < N + 1; i++) {
			boolean[] visited = new boolean[N + 1]; // 방문처리 용도

			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(i, 0));
			time[i][i] = 0;

			while (!pq.isEmpty()) {
				Node curr = pq.poll();

				if (visited[curr.end])
					continue;

				visited[curr.end] = true;

				for (Node node : adjList[curr.end]) {
					if(!visited[node.end] && time[i][node.end] > time[i][curr.end]+ node.time) {
						time[i][node.end] = time[i][curr.end]+node.time;
						
						pq.add(new Node(node.end, time[i][node.end]));
					}
				}

			}
		} // 모든 경우의 최단경로를 구함.

		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken()); // 서비스를 요청한 손님이 위치한 파티장 번호
			int B = Integer.parseInt(st.nextToken()); // 다음 파티가 열리는 파티장 번호
			int C = Integer.parseInt(st.nextToken()); // 지금으로부터 다음 파티가 열리는데 걸리는 시간

			if(time[A][B] <= C) { // 가는데 걸리는 시간이 파티가 열리는데 걸리는 시간보다 작거나 같다면
				sb.append("Enjoy other party").append('\n');
				continue;
			}
			sb.append("Stay here").append('\n');
		}
		
		System.out.println(sb);

	}
}