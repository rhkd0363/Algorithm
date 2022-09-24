import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static boolean[] check;
	static int N;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		check = new boolean[N];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(ans);
	}

	static void dfs(int idx) {
		if (idx == N) {
			int sum = 0;
			int sum_ = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (check[i] && check[j]) {
						sum += board[i][j];
						sum += board[j][i];
					} else if (!check[i] && !check[j]) {
						sum_ += board[i][j];
						sum_ += board[j][i];

					}
				}
			}
			ans = Math.min(ans, Math.abs(sum - sum_));
			return;
		}

		check[idx] = true;
		dfs(idx + 1);
		check[idx] = false;
		dfs(idx + 1);

	}
}
