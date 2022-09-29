import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int N, K, ans;
	static boolean[] visited;
	
	static class Node implements Comparable<Node>{
		int v;
		int time;
		
		public Node(int v, int time) {
			super();
			this.v = v;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time -  o.time;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[200001];
		
		dijkstra(N);
		
		System.out.println(ans);
	}
	
	static void dijkstra(int str) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(str,0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(curr.v == K) {
				ans = curr.time;
				return;
			}
			
			if(curr.v >= visited.length || curr.v < 0 || visited[curr.v])
				continue;
			
			visited[curr.v] = true;
			
			pq.add(new Node(curr.v-1,curr.time+1));
			pq.add(new Node(curr.v+1,curr.time+1));
			pq.add(new Node(curr.v*2,curr.time));
		}
		
	}
	
	
	
	
}