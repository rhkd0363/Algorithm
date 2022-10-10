import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++)
			Arrays.fill(map[i], 987654321);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
		}

		floydWarshall(map, N);

		int ans = 0;

		for (int i = 0; i < N; i++) {
			if (i == X - 1)
				continue;
			ans = Math.max(ans, map[i][X - 1] + map[X - 1][i]);
		}

		System.out.println(ans);

	}

	static void floydWarshall(int[][] map, int N) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < N; j++) {
					if (k == j || i == j)
						continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
	}
}