import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[] coin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			coin = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++)
				coin[i] = Integer.parseInt(st.nextToken());

			M = Integer.parseInt(br.readLine());
			
			int[] dp = new int[M+1];
			dp[0] = 1;
			
			for(int i=0;i<N;i++) {
				for(int j=coin[i];j<M+1;j++) {
					dp[j] += dp[j-coin[i]];
				}
			}
			
			sb.append(dp[M]).append('\n');
		}
		System.out.println(sb);
	}
}