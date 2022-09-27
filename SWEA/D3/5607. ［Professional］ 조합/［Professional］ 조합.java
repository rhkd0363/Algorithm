import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Solution {
	static long P = 1234567891;
	static long[] factorial;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		factorial = new long[1000001];
		factorial[0] = 1;

		for (int i = 1; i < 1000001; i++) {
			factorial[i] = factorial[i - 1] * i;
			factorial[i] %= P;
		}

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long ans = factorial[N] * pow(factorial[N - R] * factorial[R] % P, P - 2)%P;

			System.out.println("#"+t+" "+ans);
		}

	}

	static long pow(long x, long n) {
		if (n == 1)
			return x;
		long result = 0;
		if (n % 2 == 0) {
			result = pow(x, n / 2);
			return result * result % P;
		}
		result = pow(x, n - 1) % P;
		return (result * x) % P;

	}
}