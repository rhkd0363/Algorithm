import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int map[] = new int[N * N + 1];

		int sum = 0;
		int idx = 1;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				sum += Integer.parseInt(st.nextToken());
				map[idx++] = sum;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x_1 = Integer.parseInt(st.nextToken());
			int y_1 = Integer.parseInt(st.nextToken());
			int x_2 = Integer.parseInt(st.nextToken());
			int y_2 = Integer.parseInt(st.nextToken());

			int result = 0;

			for (int j = x_1; j <= x_2; j++) {
				result += map[N * (j - 1) + y_2] - map[N * (j - 1) + y_1 - 1];
			}

			sb.append(result).append('\n');
		}
        System.out.println(sb);
	}
}