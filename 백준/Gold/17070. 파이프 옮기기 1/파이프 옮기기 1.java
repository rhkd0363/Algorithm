import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder SB = new StringBuilder();
	static int[][] iMap;
	static int N;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		iMap = new int[N + 2][N + 2];

		// iMap 1로 초기화
		for (int i = 0; i < N + 2; i++)
			Arrays.fill(iMap[i], 1);

		// iMap 값 입력
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				iMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		// 가로 1 세로 2
		movePipe(1,2,1);
		
		System.out.println(res);

	}

	// 파이프 움직이기
	static void movePipe(int r, int c,int dir) {
		//  벽을 만나거나 범위 밖이면 리턴
		if (iMap[r][c] == 1)
			return;
		// 목적지 도착하면 결과 값 1증가 후 리턴
		else if (r == N && c == N) {
			res++;
			return;
		}
		
		// 옆 방향
		if (dir != 2) {
			movePipe(r,c+1,1);
		}
		// 아래 방향
		if (dir != 1) {
				movePipe(r+1,c,2);
		}
		// 대각선 방향 ( 파이프가 어떤 방향이든 대각선은 가능)
		if(iMap[r+1][c] == 0 && iMap[r][c+1] == 0 && iMap[r+1][c+1] == 0)
			movePipe(r+1,c+1,0);
	}
}