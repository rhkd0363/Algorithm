import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static double E;
	static int[][] island;
	static boolean[] visited;
	static Double[] dist;
	static List<Node>[] adjList;

	static class Node implements Comparable<Node> {
		int str;
		int end;
		double weight;

		public Node(int str, int end, double weight) {
			super();
			this.str = str;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			if (this.weight - o.weight > 0)
				return 1;
			else if (this.weight - o.weight < 0)
				return -1;
			else
				return 0;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 섬의 개수
			N = Integer.parseInt(br.readLine());

			// 섬의 좌표정보
			island = new int[N][2];

			// 섬의 X좌표 입력
			st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
                island[i][1] = Integer.parseInt(st2.nextToken());
			}

			adjList = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adjList[i] = new ArrayList<>();
			}

			dist = new Double[N];
			Arrays.fill(dist, Double.MAX_VALUE);

			// 간선의 정보 (무향그래프)
			for (int i = 0; i < N-1;i++) {
				for (int j = i; j < N; j++) {
					int weightX = Math.abs(island[i][0] - island[j][0]);
					int weightY = Math.abs(island[i][1] - island[j][1]);
					double distance = Math.pow(weightX, 2) + Math.pow(weightY, 2);

					adjList[i].add(new Node(i, j, distance));
					adjList[j].add(new Node(j, i, distance));

				}
			}

			// 환경 부담 세율 실수 입력
			E = Double.parseDouble(br.readLine());

			prim(0);

			double ans = 0;
			for (int i = 0; i < N; i++) {
				ans += E * dist[i];
			}

			sb.append('#').append(tc).append(' ').append(Math.round(ans)).append('\n');
		}
		System.out.println(sb);
	}

	static void prim(int str) {
		visited = new boolean[N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.addAll(adjList[str]);
		dist[str] = (double) 0;
		visited[str] = true;

		int pick = 1;

		while (pick != N) {
			Node curr = pq.poll();

			if (!visited[curr.end] && dist[curr.end] > curr.weight) {
				dist[curr.end] = curr.weight;
				visited[curr.end] = true;
				pq.addAll(adjList[curr.end]);
				pick++;
			}

		}

	}

}
