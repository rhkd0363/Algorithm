import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 우, 하 , 우하 이동 가능
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] candy = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dx = { -1, -1, 0 };
		int[] dy = { 0, -1, -1 };

		candy[N-1][M-1] = map[N-1][M-1];
		// 도착지점부터 거슬러올라감
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				for (int k = 0; k < 3; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx < 0 || ny < 0 )
						continue;
					
					candy[nx][ny] = Math.max(candy[nx][ny] , candy[i][j] + map[nx][ny]); 
				}
			}
		}
		
		System.out.println(candy[0][0]);
	}
}
