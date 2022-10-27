import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			super();
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Node>[] adjList = new ArrayList[N+1];
		
		for(int i=1;i<N+1;i++)
			adjList[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adjList[A].add(new Node(B,C));
			adjList[B].add(new Node(A,C));
		}
		
		int[] p = new int[N+1];
		
		boolean[] visited = new boolean[N+1];
		
		int[] cost = new int[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		cost[1] = 0;
		p[1] = 1;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.end])
				continue;
			
			visited[curr.end] = true;
			
			for(Node pos : adjList[curr.end]) {
				if(!visited[pos.end] && cost[pos.end] > pos.cost) {
					cost[pos.end] = pos.cost;
					pq.add(new Node(pos.end,cost[pos.end]));
					p[pos.end] = p[curr.end];
				}
			}
		}
		
		int count = 0;
		int max = 0;
		int res = 0;
		for(int i=1;i<N+1;i++) {
			if(p[i] == 0) {
				count++;
				continue;
			}
			res += cost[i];
			max = Math.max(max, cost[i]);
		}
		
		if(count == 0) {
			res -= max;
		}else {
			int idx = 0;
			
			for(int i=1;i<N+1;i++) {
				if(p[i] == 0) {
					pq.add(new Node(i,0));
					p[i] = i;
					cost[i] = 0;
					idx = i;
					break;
				}
			}
			
			while(!pq.isEmpty()) {
				Node curr = pq.poll();
				
				if(visited[curr.end])
					continue;
				
				visited[curr.end] = true;
				
				for(Node pos : adjList[curr.end]) {
					if(!visited[pos.end] && cost[pos.end] > pos.cost) {
						cost[pos.end] = pos.cost;
						pq.add(new Node(pos.end,cost[pos.end]));
						p[pos.end] = p[curr.end];
					}
				}
			}
			
			for(int i=1;i<N+1;i++) {
				if(p[i] == idx) {
					res +=cost[i];
				}
			}
		}
		
		System.out.println(res);
	}
}
