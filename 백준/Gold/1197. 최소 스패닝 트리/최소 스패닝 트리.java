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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<int[]>[] adjList = new ArrayList[V+1];
		
		for(int i=1;i<V+1;i++)
			adjList[i] = new ArrayList<>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[start].add(new int[] {end,weight});
			adjList[end].add(new int[] {start,weight});
		}
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] check = new boolean[V+1];
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
			
		});
		pq.add(new int[] {1,0});
		dist[1] = 0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			
			if(check[curr[0]])
				continue;
			
			check[curr[0]] = true;
			
			for(int[] pos : adjList[curr[0]]) {
				if(!check[pos[0]] && dist[pos[0]] > pos[1]) {
					dist[pos[0]] = pos[1];
					pq.add(new int[] {pos[0],dist[pos[0]]});
				}
			}
		}
		
		int ans = 0;
		
		for(int i=1;i<V+1;i++)
			ans += dist[i];
		
		System.out.println(ans);
	}
}