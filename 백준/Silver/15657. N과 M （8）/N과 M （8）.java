import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;
	static boolean[] check;
	static int[] ans;
	static StringBuilder SB = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		check = new boolean[N];
		ans = new int[M];

		st = new StringTokenizer(br.readLine());
		int i = 0;
		while (st.hasMoreTokens()) {
			nums[i++] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		NandM(0,0);

		System.out.println(SB);
	}

	static void NandM(int idx, int sidx) {
		if (sidx == M) {
			for (int i = 0; i < M; i++) {
				SB.append(ans[i]).append(' ');
			}
			SB.append('\n');
			return;
		}

		for (int i = idx; i < N; i++) {
			ans[sidx] = nums[i];
			NandM(i,sidx+1);

		}
	}
}