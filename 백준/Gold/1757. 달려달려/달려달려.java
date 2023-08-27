import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[N+1][M+1][2];
        for(int i=1;i<=N;i++){
            int dist = Integer.parseInt(br.readLine());
            for(int j=0;j<=M;j++){
                if(j == 0){
                    dp[i][j][0] = Math.max(dp[i-1][j][0], Math.max(dp[i-1][j+1][0],dp[i-1][j+1][1]));
                }else if(j == M){
                    dp[i][j][0] = dp[i-1][j-1][0] + dist;
                    dp[i][j][1] = dp[i-1][j-1][0] + dist;
                }else{
                    dp[i][j][0] = dp[i-1][j-1][0] + dist;
                    dp[i][j][1] = Math.max(dp[i-1][j+1][0],dp[i-1][j+1][1]);
                }
            }
        }
        System.out.println(dp[N][0][0]);
    }
}