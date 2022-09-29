import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//크루스칼
public class Solution {
	static int[] p;
	
	static class Node{
		int start;
		int end;
		int weight;
		public Node(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 정점, 간선 수
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<Node> edges = new ArrayList<>();
			
			// 간선 정보
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edges.add(new Node(start, end, weight));
			}
			
			// 가중치 기준 정렬
			Collections.sort(edges, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.weight - o2.weight;
				}
			});
			
			// 대표자 배열
			p = new int[V+1];
			
			// 대표자 배열 초기화
			for(int i=0;i<V;i++) {
				makeSet(i);
			}
			
			// 결과, 선택된 간선의 수
			long ans = 0, pick = 0;
			
			for(int i=0;i<E;i++) {
				int px = findSet(edges.get(i).start);
				int py = findSet(edges.get(i).end);
				int weight = edges.get(i).weight;
				
				// 서로 대표가 다르면 합친다.
				if(px != py) {
					union(px,py);
					ans += weight;
					pick++;
				}
				
				// 간선의 수가 정점 -1 개가 되면 멈춘다.
				if(pick == V-1)
					break;
			}
			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void union(int x,int y) {
		p[y] = x;
	}
	
	static int findSet(int x) {
		if(p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	static void makeSet(int x) {
		p[x] = x;
	}
}