import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];
        int start = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int wTime = Integer.parseInt(st.nextToken());
            int wMoney = Integer.parseInt(st.nextToken());
            int bTime = Integer.parseInt(st.nextToken());
            int bMoney = Integer.parseInt(st.nextToken());
            getDP(dp,i,K,start, wTime,wMoney);
            getDP(dp,i,K,start, bTime,bMoney);
            start = Math.min(start+wTime, start+bTime);
        }
        System.out.println(dp[N][K]);
    }

    static void getDP(int[][] dp, int i, int K,int start, int time, int money){
        for (int j = start + time; j <= K; j++) {
            int value = dp[i - 1][j - time] + money;
            dp[i][j] = Math.max(dp[i][j],value);
        }
    }
}