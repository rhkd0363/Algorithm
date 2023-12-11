import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());

        // 남은 수 가야할 곳 인덱스
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i], -1);

        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            dp[i][i] = m - num;
        }

        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                if(dp[i][j-1] - arr[j] - 1 < 0)
                    break;

                dp[i][j] = dp[i][j-1] - arr[j] - 1;
            }
        }

        dfs(1, n, dp);

        System.out.println(dp[1][0]);

    }

    static int dfs(int idx, int n, int[][] dp){
        if(idx == n || dp[idx][n] != -1)
            return 0;

        if(dp[idx][0] != -1)
            return dp[idx][0];

        int min = Integer.MAX_VALUE;

        for(int i = 0;idx + i < n;i++){
            if(dp[idx][idx + i] == -1)
                break;

            min = Math.min((int)Math.pow(dp[idx][idx + i], 2) + dfs(idx + i + 1, n, dp), min);
        }

        dp[idx][0] = min;

        return min;
    }

}