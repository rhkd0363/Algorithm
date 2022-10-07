import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder SB = new StringBuilder();
	static int N;
	static long[] factorial;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		// 팩토리얼 구하기
		factorial = new long[N];
		getFactorial();

		// 소문제 데이터 입력
		st = new StringTokenizer(br.readLine());
		int prob = Integer.parseInt(st.nextToken());

		if (prob == 1) {
			long K = Long.parseLong(st.nextToken()); // 20 고로

			getPerm(K);
		} else {
			int perm[] = new int[N];

			for (int i = 0; i < N; i++)
				perm[i] = Integer.parseInt(st.nextToken());

			getCount(perm);
		}

		System.out.println(SB);
	}

	static void getFactorial() {
		factorial[0] = 1;
		for (int i = 1; i < N; i++) { // 팩토리얼 구하기
			factorial[i] = factorial[i - 1] * i;
		}
	}

	static void getPerm(long K) {
		boolean[] check = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (check[j])
					continue;
				if (K <= factorial[N - i]) {
					SB.append(j).append(' ');
					check[j] = true;
					break;
				}
				K = K - factorial[N - i];
			}
		}
	}

	static void getCount(int[] perm) {
		boolean[] check = new boolean[N + 1];
		long result = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (check[j])
					continue;

				if (perm[i] == j) {
					check[j] = true;
					break;
				}
				result += factorial[N - i - 1];
			}
		}

		SB.append(result);
	}
}