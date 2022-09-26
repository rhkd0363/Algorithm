import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] stNum;
	static boolean[] check, res;
	static int N, k, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()) + 1;
			stNum = new int[N];
			check = new boolean[N];
			res = new boolean[N];
			cnt = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N; i++) {
				stNum[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < N; i++) {
				dfs(i);
			}

			sb.append(stNum.length - cnt - 1).append('\n');

		}

		
		System.out.println(sb);

	}

	static void dfs(int i) {
		if (check[i])
			return;

		check[i] = true;

		if (check[stNum[i]] != true) {
			dfs(stNum[i]);
		}

		if(res[stNum[i]] != true) {
			cnt++;
			for(int j=stNum[i]; j != i;j = stNum[j]) {
				cnt++;
			}
		}
		
		res[i] = true;

	}
}