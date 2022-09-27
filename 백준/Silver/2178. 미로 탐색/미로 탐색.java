import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, M 입력
		st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		
		 map = new int[N][M];
		 visited = new boolean[N][M];
		 
		 // map 정보 입력
		 for(int i=0;i<N;i++) {
			 String data = br.readLine();
			 for(int j=0;j<M;j++) {
				 map[i][j] = data.charAt(j)-'0';
			 }
		 }
		 
		 int result = bfs(0);
		 
		 System.out.println(result);
	}
	
	
	static int bfs(int count) {
		queue.add(new int[] {0,0});
		
		out : while(!queue.isEmpty()) {
			count++;
			int size = queue.size();
			for(int i=0;i<size;i++) {
				int[] pos = queue.poll();
				
				if(pos[0] == N-1 && pos[1] == M-1)
					break out;
				
				for(int j=0;j<4;j++) {
					int nx = pos[0] + dx[j];
					int ny = pos[1] + dy[j];
					
					if(nx >= N || ny >= M || nx < 0 || ny < 0)
						continue;
					
					if(!visited[nx][ny] && map[nx][ny] == 1) {
						visited[nx][ny] = true;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
		
		return count;
	}
}