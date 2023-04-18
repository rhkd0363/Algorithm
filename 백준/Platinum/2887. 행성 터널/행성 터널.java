import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight - o.weight;
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static List<Edge>[] adjList;
	static int V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine()); // 정점의 개수

		// 인접 리스트 초기화
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		int point[][] = new int[V][4];

		// 정점 정보 입력
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			point[i][0] = x;
			point[i][1] = y;
			point[i][2] = z;
			point[i][3] = i;
		}

		sortArr(point, 0);

		sortArr(point, 1);

		sortArr(point, 2);

		// 방문 배열
		boolean[] visited = new boolean[V];
		int[] p = new int[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		// 시작정점 선택
		visited[0] = true;
		p[0] = -1;

		// 시작정점에 연결된 정보를 우선순위 큐에 넣어준다.
		pq.addAll(adjList[0]);

		int pick = 1; // 확보한 정점의 개수
		int ans = 0;

		while (pick != V) {
			// 가중치가 가장 작은 값이 뽑아져 나옴(최소힙)
			Edge edge = pq.poll(); // 연결된 간선을 하나 뽑는다.
			if (visited[edge.end])
				continue;

			
			ans += edge.weight;
			p[edge.end] = edge.start;
			pq.addAll(adjList[edge.end]);
			visited[edge.end] = true;
			pick++;
		}

		System.out.println(ans);
	}

	static void sortArr(int[][] arr, int number) {
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[number] - o2[number];
			}
		});
		
		for(int i=0;i<V-1;i++) {
			adjList[arr[i][3]].add(new Edge(arr[i][3], arr[i+1][3], Math.abs(arr[i][number]-arr[i+1][number])));
			adjList[arr[i+1][3]].add(new Edge(arr[i+1][3], arr[i][3], Math.abs(arr[i][number]-arr[i+1][number])));			
		}
	}
}