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

public class Main {
	static class Node implements Comparable<Node>{
		int v;
		long cost;
		
		public Node(int v, long cost) {
			super();
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 건물 수
		int M = Integer.parseInt(st.nextToken()); // 도로 수

		List<Node>[] adjList = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		long[] cost = new long[N+1];
		Arrays.fill(cost, Long.MAX_VALUE);
		
		boolean[] visited = new boolean[N+1];
		
		long ans = 0;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			ans += weight;
			
			adjList[str].add(new Node(end,weight));
			adjList[end].add(new Node(str,weight));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		cost[1] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.v])
				continue;
			
			visited[curr.v] = true;
			
			for(Node node : adjList[curr.v]) {
				if(!visited[node.v] && cost[node.v] > node.cost) {
					cost[node.v] = node.cost;
					pq.add(new Node(node.v, cost[node.v]));
				}
			}
		}
		
		for(int i=1;i<cost.length;i++) {
			if(cost[i] == Long.MAX_VALUE) {
				ans = -1;
				break;
			}
			ans -= cost[i];
		}

		System.out.println(ans);
	}
}