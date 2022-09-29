import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	static int[] p;
	static int[] dist;
	static boolean[] visited;
	static List<Node>[] adjList;

	static class Node implements Comparable<Node> {
		int str;
		int end;
		int w;

		public Node(int str, int end, int w) {
			super();
			this.str = str;
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Node [str=" + str + ", end=" + end + ", w=" + w + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// N, M 입력
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine());

		p = new int[V + 1];
		dist = new int[V + 1];
		visited = new boolean[V + 1];
		adjList = new ArrayList[V + 1];

		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			// 방향 그래프
			adjList[str].add(new Node(str, end, w));
		}

		// K번째 초기화
		dist[K] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, K, 0));

		while (!pq.isEmpty()) {

			Node curr = pq.poll();

			if (visited[curr.end])
				continue;

			visited[curr.end] = true;

			for (Node node : adjList[curr.end]) {
				if (!visited[node.end] && dist[node.end] > dist[node.str] + node.w) {
					dist[node.end] = dist[node.str] + node.w;

					pq.add(new Node(node.str, node.end, dist[node.end]));
				}
			}
		}

		for (int i = 1; i < V + 1; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				sb.append("INF");
			else
				sb.append(dist[i]);
			sb.append('\n');
		}

		System.out.println(sb);

	}
}
