import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 먼저 풀수있는건 먼저푸는데 대신 쉬운거있으면 그거부터
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adjList = new ArrayList[N+1];
		
		for(int i=1;i<N+1;i++)
			adjList[i] = new ArrayList<>();
		
		int[] inDegree = new int[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			adjList[prev].add(next);
			inDegree[next]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=1;i<N+1;i++)
			if(inDegree[i] == 0)
				pq.add(i);
		
		while(!pq.isEmpty()) {
			int curr = pq.poll();
			
			sb.append(curr).append(' ');
			
			for(int pos : adjList[curr]) {
				inDegree[pos]--;
				if(inDegree[pos] == 0)
					pq.add(pos);
			}
		}
		
		System.out.println(sb);
	}
}

/*
 * 진입차수를 체크하기 위한 inDegree 함수
 * 
 * 진출을 확인하기 위한 adjList
 * 
 * 진입차수가 0인 애들을 큐에 넣고 진행
 * 
 * 큐에서 하나씩 꺼내면서 다음으로 진행할 애들을 확인한다.
 * 
 * 진입차수를 하나씩 줄이고, 진입차수가 0이되면 큐에 넣어준다.
 * 
 */

//위상정렬은 진입차수가 없는 애들부터 시작한다.
