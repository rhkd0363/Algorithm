import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int N, E, V1, V2;
	static List<Node>[] adjList;
	static boolean[] visited;
	static double[] dist;
	
	static class Node implements Comparable<Node>{
		int v;
		double weight;
		
		public Node(int v, double weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 정점의 수, 간선의 수 입력
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 인접리스트 생성 및 초기화
		adjList = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		
		// 간선 정보 입력
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[start].add(new Node(end, weight));
			adjList[end].add(new Node(start, weight));
		}
		
		// 지나야 하는 두개의 정점 입력
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());
		
		//정답 가능한 상황
		//1 -> v1 -> v2 -> N
		//1 -> v2 -> v1 -> N
		//1 -> v1 -> 1 -> v2 -> N
		//1 -> v2 -> 1 -> v1 -> N
		//1 -> v1 -> 1 -> v2 -> 1 -> N
		
		double[] ans = new double[5];
		
		// 거리 배열 생성 및 초기화
		dist = new double[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 방문 배열 생성
		visited = new boolean[N+1];
				
		
		dijkstra(1);
		ans[0] = dist[V1];
		ans[1] = dist[V2];
		ans[2] = dist[V1]*2 + dist[V2];
		ans[3] = dist[V2]*2 + dist[V1];
		ans[4] = dist[V2]*2 + dist[V1]*2 + dist[N]; //완료
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[N+1];
		
		dijkstra(V1);
		
		ans[0]   += dist[V2];
		ans[1]   += dist[N];
		ans[3] += dist[N]; // 완료
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[N+1];
		
		dijkstra(V2);
		
		ans[0]   += dist[N]; // 완료
		ans[1]   += dist[V1]; //완료
		ans[2] += dist[N]; //완료
		
		double res = Integer.MAX_VALUE;
		
		for(int i=0;i<5;i++) {
			res = Math.min(res, ans[i]);
		}
		
		
		if(Math.abs(res) >= Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println((int)res);
		
	}
	
	// 1번 정점에서 V1 가는 거리, 1번 정점에서 V2 가는 거리, V1에서 V2 가는 거리, V1.V2 에서 N 가는 거리

	static void dijkstra(int str) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(str,0));
		dist[str] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.v])
				continue;
			
			visited[curr.v] = true;
			
			for(Node node : adjList[curr.v]) {
				if(!visited[node.v] && dist[node.v] > dist[curr.v] + node.weight) {
					dist[node.v] = dist[curr.v] + node.weight;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
	}
}