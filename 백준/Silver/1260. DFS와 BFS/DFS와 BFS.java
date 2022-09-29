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
	static int N, M, V;
	static int[] p;
	static List<Integer>[] adjList;
	static boolean[] visited;
	
	static StringBuilder SB = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];

		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			adjList[str].add(end);
			adjList[end].add(str);
		}
		
		
		for(int i=0;i<N+1;i++)
			Collections.sort(adjList[i]);
		
		dfs(V);

		SB.append('\n');
		
		visited = new boolean[N + 1];
		
		bfs(V);
		
		System.out.println(SB);
	}

	static void dfs(int v) {
		if (visited[v])
			return;
		
		SB.append(v+" ");

		visited[v] = true;

		for (int i = 0; i < adjList[v].size(); i++) {
			if (!visited[adjList[v].get(i)])
				dfs(adjList[v].get(i));
		}
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);

		while (!queue.isEmpty()) {
			int pos = queue.poll();

			if (visited[pos])
				continue;

			SB.append(pos + " ");

			visited[pos] = true;

			for (int i = 0; i < adjList[pos].size(); i++) {
				if (!visited[adjList[pos].get(i)])
					queue.add(adjList[pos].get(i));
			}
		}

	}
}