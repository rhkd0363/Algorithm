import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[100001];
        dp[1] = 1;
        int[] result = new int[100001];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            for (int j = 1; j * number < 100001; j++) {
                result[j * number] += getResult(j, dp);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            sb.append(result[Integer.parseInt(st.nextToken())] + " ");

        System.out.println(sb);
    }

    static int getResult(int number, int[] dp) {
        if (dp[number] != 0)
            return dp[number];

        dp[number] = 1;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {

                if (Math.pow(i, 2) == number)
                    dp[number] += getResult(i, dp);
                else
                    dp[number] += getResult(i, dp) + getResult(number / i, dp);
            }
        }
        return dp[number];
    }
}