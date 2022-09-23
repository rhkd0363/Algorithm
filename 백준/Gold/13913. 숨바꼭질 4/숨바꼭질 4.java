import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] visited = new int[100001];
	static int[] path = new int[100001];
	static int len = 100001;
	static int N, k;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		

		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(N);
		visited[N] = 0;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			if(curr == K) {
				break;
			}
			
			if(curr+1 < len && curr+1 >= 0 && visited[curr+1] ==0) {
				visited[curr+1] = visited[curr]+1;
				queue.add(curr+1);
				path[curr+1] = curr;
				
			}
			if(curr-1 < len && curr-1 >= 0 && visited[curr-1] ==0) {
				visited[curr-1] = visited[curr]+1;
				queue.add(curr-1);
				path[curr-1] = curr;
				
			}
			if(curr*2 < len && curr*2 >= 0 && visited[curr*2] ==0) {
				visited[curr*2] = visited[curr]+1;
				queue.add(curr*2);
				path[curr*2] = curr;
				
			}
			
		}
		
		List<Integer> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		sb.append(visited[K]).append('\n');
		ans.add(K);
		int a = K;
		while(true) {
			if(a == N)
				break;
			ans.add(path[a]);
			a = path[a];
		}
		
		for(int i=ans.size()-1;i>=0;i--) {
			sb.append(ans.get(i)).append(' ');
		}
		
		System.out.println(sb);
	}
}