import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] loc;
	static boolean[] check;
	static int N;
	static int compX, compY, homeX, homeY;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			ans = Integer.MAX_VALUE;
			loc = new int[N][2];
			check = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());

			compX = Integer.parseInt(st.nextToken());
			compY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());

			// 회사, 집, 고객 좌표 입력
			for (int i = 0; i < N; i++) {
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
			}

			getDist(compX, compY, 0, 0);

			System.out.println("#" + t + " " + ans);
		}

	}

	static void getDist(int x_pos, int y_pos, int idx, int result) {
        if(result > ans) return;
        
		if (idx == N) {
			ans = Math.min(ans, result+Math.abs(x_pos - homeX) + Math.abs(y_pos - homeY));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				getDist(loc[i][0], loc[i][1], idx + 1, result + Math.abs(x_pos - loc[i][0]) + Math.abs(y_pos - loc[i][1]));
				check[i] = false;
			}
		}
	}
}

//회사 위치에서 시작해서 전부 다돌고 집으로 돌아오는 경우 중 최단 거리.
