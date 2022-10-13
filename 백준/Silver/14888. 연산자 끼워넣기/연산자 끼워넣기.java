import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num, oper, check;
	static int N, resMax, resMin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		oper = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			oper[i] = Integer.parseInt(st.nextToken());

		resMax = Integer.MIN_VALUE;
		resMin = Integer.MAX_VALUE;

		check = new int[N - 1];

		dfs(0);

		System.out.println(resMax + " " + resMin);
	}

	static void dfs(int n) {
		if (n == N - 1) {
			int res = num[0];
			for (int i = 0; i < check.length; i++) {
				switch (check[i]) {
				case 0:
					res += num[i+1];
					break;
				case 1:
					res -= num[i+1];
					break;
				case 2:
					res *= num[i+1];
					break;
				case 3:
					res /= num[i+1];
					break;
				}
			}

			resMax = Math.max(resMax, res);
			resMin = Math.min(resMin, res);

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (oper[i] != 0) {
				check[n] = i;
				oper[i]--;
				dfs(n + 1);
				oper[i]++;
			}
		}
	}
}
