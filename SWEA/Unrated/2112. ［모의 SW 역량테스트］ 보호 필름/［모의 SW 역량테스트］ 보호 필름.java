import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K, ans;
	static int[][] film;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken()); // 보호 필름의 두께 (세로)
			W = Integer.parseInt(st.nextToken()); // 가로 크기
			K = Integer.parseInt(st.nextToken()); // 합격 기준

			film = new int[D][W];
			visited = new boolean[D][2];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = -1;

			for (int i = 0; i <= K; i++) {
				dfs(0, 0, i);
				if (ans != -1)
					break;
			}

			sb.append("#" + tc + " " + ans).append('\n');

		}
		System.out.println(sb);
	}

	// 트루인 줄 찾아서 변경???

	static void dfs(int idx, int sidx, int E) {
		if (ans != -1)
			return;

		if (sidx == E) {
			// 트루일시 결과처리
			if (change()) {
				ans = sidx;
			}

			return;
		}

		for (int i = idx; i < D; i++) {
			for (int j = 0; j < 2; j++) {

				visited[i][j] = true;
				int[] temp = film[i].clone();
				Arrays.fill(film[i], j);

				dfs(i + 1, sidx + 1, E);

				visited[i][j] = false;
				film[i] = temp;
			}
		}

	}

	static boolean change() {
		fo: for (int i = 0; i < W; i++) {
			int count = 1;
			int check = film[0][i];
			for (int j = K == 1 ? 0 : 1; j < D; j++) {
				if (film[j][i] != check) {
					count = 1;
					check = film[j][i];
				} else {
					count++;
					if (count >= K) {
						continue fo;
					}
				}
			}
			return false;
		}
		return true;
	}
}