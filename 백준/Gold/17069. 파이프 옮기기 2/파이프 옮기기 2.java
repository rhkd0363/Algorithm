import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 우, 하 , 우하 이동 가능
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N+2][N+2];
		long[][][] pipe = new long[3][N + 2][N + 2]; // 0 가로 1세로 2 대각선

		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pipe[0][1][2] = 1; // 시작지점(가로방향)

		for (int i = 1; i < N + 1; i++) {
			for (int j = 2; j < N + 1; j++) {
				if (map[i][j + 1] != 1) // 가로
					pipe[0][i][j + 1] = pipe[0][i][j] + pipe[2][i][j];
				if (map[i + 1][j] != 1) // 세로
					pipe[1][i + 1][j] = pipe[1][i][j] + pipe[2][i][j];
				if (map[i][j + 1] != 1 && map[i + 1][j] != 1 && map[i + 1][j + 1] != 1) // 대각선
					pipe[2][i + 1][j + 1] = pipe[0][i][j] + pipe[1][i][j] + pipe[2][i][j];
			}
		}
		
		long ans = pipe[0][N][N] + pipe[1][N][N] + pipe[2][N][N];
		System.out.println(ans);
	}
}