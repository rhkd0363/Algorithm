import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][1200];
        for (int i = 0; i <= N; i++)
            Arrays.fill(dp[i], 987654321);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());
            dp[i][0] = 0;

            for(int j=1;j<person;j++)
                dp[i][j] = dp[i-1][j];
            for (int j = person; j < 1200; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j-person] + cost);
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=C;i<1200;i++)
            answer = Math.min(answer, dp[N][i]);

//        for(int[] a : dp) System.out.println(Arrays.toString(a));

        System.out.println(answer);
    }
}