import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int DIV_VAL = 1_000_000_000;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N+1][K];

        for (int i = 0; i <= N; i++) // 숫자 1개 뽑아서 해당 숫자를 만들 수 있는 경우의 수
            dp[i][0] = 1;
        for (int i = 0; i < K; i++) // 0으로 만들 수 있는 경우 1개 ( 0, 0+0, 0+0+0 ...)
            dp[0][i] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < K; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % DIV_VAL;
            }
        }
        System.out.println(dp[N][K-1]);
    }
}