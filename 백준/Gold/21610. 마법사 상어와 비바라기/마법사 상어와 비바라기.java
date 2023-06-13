import java.io.*;
import java.util.*;

//
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> commandList = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			commandList.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		// 구름위치 정보.
		boolean[][] cloudMap = new boolean[N][N];
		
		//현재 구름 위치정보를 담을 목록이 필요하고, 
		Queue<int[]> cloudList = new LinkedList<>();
		
		cloudList.add(new int[] {N-1,0});
		cloudList.add(new int[] {N-1,1});
		cloudList.add(new int[] {N-2,0});
		cloudList.add(new int[] {N-2,1});
		
		// 방향 정보 ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 
		int[][] dir = {{0,0}, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
		
		while (!commandList.isEmpty()) {
			int[] command = commandList.poll();
			
			int size = cloudList.size();
			
            // 움직인 구름 위치 정보
			Queue<int[]> movedCloudList = new LinkedList<>();
			
			// 구름 이동
			for(int i=0; i< size;i++) {
				int[] cloudPos = cloudList.poll();
				
				cloudPos[0] += dir[command[0]][0]*command[1];
				cloudPos[1] += dir[command[0]][1]*command[1];
				
				if(cloudPos[0] < 0) {
					int num = cloudPos[0] % N;
					cloudPos[0] = num == 0 ? 0 : N + num;
				}
				else
					cloudPos[0] = cloudPos[0] % N;
				
				if(cloudPos[1] < 0) {
					int num = cloudPos[1] % N;
					cloudPos[1] = num == 0 ? 0 : N + num;
				}
				else
					cloudPos[1] = cloudPos[1] % N;
				
				map[cloudPos[0]][cloudPos[1]]++;
				movedCloudList.add(cloudPos);
			}
			
			for(int i=0; i< size;i++) {
				int[] cloudPos = movedCloudList.poll();
				
				cloudMap[cloudPos[0]][cloudPos[1]] = true;
				
				
				for(int j=2;j<dir.length;j+=2) {
					int nr = cloudPos[0] + dir[j][0];
					int nc = cloudPos[1] + dir[j][1];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] < 1)
						continue;
					
					map[cloudPos[0]][cloudPos[1]]++;
				}	
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] >= 2 && !cloudMap[i][j]) {
						map[i][j] -= 2;
						cloudList.add(new int[] {i,j});
					}
				}
			}
			
			cloudMap = new boolean[N][N];

		}
		
		int result = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				result += map[i][j];
			}			
		}
		
		System.out.println(result);
	}
}
