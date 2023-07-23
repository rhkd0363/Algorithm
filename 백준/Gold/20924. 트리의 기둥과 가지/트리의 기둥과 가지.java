import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int start;
		int end;
		int dist;

		public Node(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		List<Node>[] adjList = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++)
			adjList[i] = new ArrayList<Node>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			adjList[start].add(new Node(start, end, dist));
			adjList[end].add(new Node(end, start, dist));
		}

		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(0, R, 0));

		boolean[] visited = new boolean[N + 1];

		boolean checkGiga = false;
		int pillar = 0;
		int maxBranch = 0;

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			if (visited[curr.end]) {
				continue;
			}

			visited[curr.end] = true;

			if (checkGiga && adjList[curr.end].size() == 1) {
				maxBranch = Math.max(maxBranch, curr.dist);
				continue;
			}

			for (Node node : adjList[curr.end]) {
				if (!visited[node.end]) {
					if (checkGiga) { // 기가노드를 찾았다면
						node.dist += curr.dist;
					}
					queue.add(node);
				}
			}

			if (!checkGiga) {
				if (adjList[curr.end].size() > 2 || (curr.end == R && adjList[curr.end].size() > 1)) {
					checkGiga = true;
				}
				pillar += curr.dist;
			}
		}

		System.out.println(pillar + " " + maxBranch);
	}
}