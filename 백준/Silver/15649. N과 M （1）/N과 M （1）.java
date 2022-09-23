import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder SB = new StringBuilder();
	static int N, M;
	static boolean[] check;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new boolean[N];
		nums = new int[M];

		perm(0, 0);

		System.out.println(SB);
	}

	static void perm(int idx, int sidx) {
		if (sidx == M) {
			for (int i = 0; i < M; i++) {
				SB.append(nums[i]).append(' ');
			}
			SB.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				nums[sidx] = i+1;
				perm(i + 1, sidx + 1);
				check[i] = false;
			}
		}

	}
}
