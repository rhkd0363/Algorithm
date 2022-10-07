import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상정렬
public class Main {
	static int M, N;
	static int[][] memo;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adjList = new ArrayList[N+1];
		int[] in_degree = new int[N+1];
		
		for(int i=1;i<N+1;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			in_degree[end]++; //진입차수
			
			adjList[start].add(end);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1;i<N+1;i++) {
			if(in_degree[i] == 0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int start = queue.poll();
			
			sb.append(start).append(' ');
			
			for(int i : adjList[start]) {
				in_degree[i]--;
				if(in_degree[i] == 0)
					queue.add(i);
			}
		}
		
		System.out.println(sb);
	}
}