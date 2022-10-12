import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R,cnt;
	static List<Integer>[] adjList;
	static int[] order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		
		for(int i=0;i<N+1;i++)
			adjList[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		for(int i=0;i<adjList.length;i++)
			Collections.sort(adjList[i],Collections.reverseOrder());
		
		order = new int[N+1];
		
		cnt = 1;
		
		bfs(R);
		
		for(int i=1;i<order.length;i++) {
			sb.append(order[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int r) {	
		Queue<Integer> queue = new LinkedList<>();
		queue.add(r);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			if(order[curr] != 0)
				continue;
			
			order[curr] = cnt++;
			
			for(int i=0;i<adjList[curr].size();i++) {
				if(order[adjList[curr].get(i)] == 0) {
					queue.add(adjList[curr].get(i));
				}
			}
		}
	}
}