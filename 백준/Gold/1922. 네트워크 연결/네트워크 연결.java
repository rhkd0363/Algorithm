import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int end;
		int weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Node>[] adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[start].add(new Node(end, weight));
			adjList[end].add(new Node(start, weight));
		}

		boolean[] visited = new boolean[N + 1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.addAll(adjList[1]);
		
		visited[1] = true;
		
		int ans = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.end])
				continue;
			
			visited[curr.end] = true;
			ans += curr.weight;
			
			pq.addAll(adjList[curr.end]);
		}

		System.out.println(ans);
	}
}
