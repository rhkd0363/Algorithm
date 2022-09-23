import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder SB = new StringBuilder();
	static int N, M;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];

		perm(0);

		System.out.println(SB);
	}

	static void perm(int sidx) {
		if (sidx == M) {
			for (int i = 0; i < M; i++) {
				SB.append(nums[i]).append(' ');
			}
			SB.append('\n');
			return;
		}

		for (int i = sidx == 0 ? 1 : nums[sidx - 1]; i <= N; i++) {
			nums[sidx] = i;
			perm(sidx + 1);
//			}
		}

	}
}
