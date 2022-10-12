import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		List<Integer>[] adjList = new ArrayList[V+1];
		
		for(int i=1;i<V+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			adjList[str].add(end);
			adjList[end].add(str);
		}
		
		boolean[] visited = new boolean[V+1];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		
		int ans = 0;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			visited[curr] = true;
			ans++;
			
			for(int pos : adjList[curr]) {
				if(!visited[pos]) {
					visited[pos] = true;
					queue.add(pos);
				}
			}
		}
		
		System.out.println(ans-1);
	}
}