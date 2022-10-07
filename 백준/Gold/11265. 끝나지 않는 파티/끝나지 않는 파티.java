import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

		int[][] time = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				time[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N + 1; i++) // 경유 지점
			for (int j = 1; j < N + 1; j++) { // 출발 지점
				if (i == j)
					continue;
				for (int k = 0; k < N + 1; k++) { // 도착 지점
					if (i == k || j == k)
						continue;
					time[j][k] = Math.min(time[j][i] + time[i][k], time[j][k]);
				}
			}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken()); // 서비스를 요청한 손님이 위치한 파티장 번호
			int B = Integer.parseInt(st.nextToken()); // 다음 파티가 열리는 파티장 번호
			int C = Integer.parseInt(st.nextToken()); // 지금으로부터 다음 파티가 열리는데 걸리는 시간

			if (time[A][B] <= C) { // 가는데 걸리는 시간이 파티가 열리는데 걸리는 시간보다 작거나 같다면
				sb.append("Enjoy other party").append('\n');
				continue;
			}
			sb.append("Stay here").append('\n');
		}

		System.out.println(sb);

	}
}