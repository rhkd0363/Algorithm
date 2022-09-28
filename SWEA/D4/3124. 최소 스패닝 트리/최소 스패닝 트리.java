import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//크루스칼 병합정렬
public class Solution {
	static int[] p;
	static int[][] sortedArr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 정점, 간선 수
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[][] edges = new int[E][3];
			// 간선 정보
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edges[i][0] = start;
				edges[i][1] = end;
				edges[i][2] = weight;
			}
			
			// 가중치 기준 정렬(병합 정렬)
			sortedArr = new int[E][3];
			mergeSort(edges,0,edges.length-1);
			
			// 대표자 배열
			p = new int[V+1];
			
			// 대표자 배열 초기화
			for(int i=0;i<V;i++) {
				makeSet(i);
			}
			
			// 결과, 선택된 간선의 수
			long ans = 0, pick = 0;
			
			for(int i=0;i<E;i++) {
				int px = findSet(edges[i][0]);
				int py = findSet(edges[i][1]);
				int weight = edges[i][2];
				
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
	
	private static void mergeSort(int[][] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 왼쪽 절반 분할
			mergeSort(arr, left, mid);
			// 오른쪽 절반 분할
			mergeSort(arr, mid + 1, right);
			// 분할된 집합 병합
			merge(arr, left, mid, right);

		}
	}

	static void merge(int[][] arr, int left, int mid, int right) {
		// 왼쪽 시작지점, 오른쪽 시작지점
		int L = left, R = mid + 1;
		// 정렬된 원소 저장할 위치
		int idx = left;

		// 합쳐지는 두 부분집합 중 어느 한 쪽이 끝까지 도달할 때까지 진행
		while (L <= mid && R <= right) {
			// 양쪽 부분집합의 값들을 비교하며 sortedArr에 값을 넣어줌
			// 조건에 등호를 넣냐 빼냐에 따라 안정정렬인지 불완전정렬인지 정해진다.
			if (arr[L][2] <= arr[R][2])
				// 값들을 넣고 증가시킨다.
				sortedArr[idx++] = arr[L++];
			else
				sortedArr[idx++] = arr[R++];
		}
		// 왼쪽이 안끝났다면
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		// 오른쪽이 안끝났다면
		else {
			for (int j = R; j <= right; j++) {
				sortedArr[idx++] = arr[j];
			}
		}

		// 원본배열에 sortedArr을 덮어씌우겠다.
		for (int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}

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