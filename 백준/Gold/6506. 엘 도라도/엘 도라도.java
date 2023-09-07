import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (N == 0 && K == 0)
                break;

            int[] numbers = new int[N];

            long[][] dp = new long[K][N];
            Arrays.fill(dp[0], 1);
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            for (int i = 0; i < K - 1; i++) {
                for (int j = 0; j < N; j++) {
                    if (dp[i][j] > 0) {
                        for (int k = j; k < N; k++) {
                            if (numbers[j] < numbers[k]) {
                                dp[i + 1][k]+=dp[i][j];
                            }
                        }
                    }
                }
            }

            for(int i=0;i<N;i++){
                answer += dp[K-1][i];
            }
            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }
}