import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;
	static boolean[] check;
	static int[] ans;

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

		perm(0);
		StringBuilder sb = new StringBuilder();
		for(String s : set) {
			sb.append(s);
		}
		System.out.println(sb);
	}
	// LinkedHashSet은 입력 순으로 정렬된다.
	static Set<String> set = new LinkedHashSet<>();
	static void perm(int idx) {
		if (idx == M) {
			StringBuilder tmp = new StringBuilder();
			for (int i = 0; i < M; i++) {
				tmp.append(ans[i]).append(' ');
			}
			tmp.append('\n');
			set.add(tmp.toString());
			return;
		}
		
		for (int i = 0; i < N; i++) {
				ans[idx] = nums[i];
				perm(idx+1);
			}

		}
	}
