import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n + 1][2]; 
        int[] dp = new int[n + 1]; 
        int max = 1; 

        for (int i = 1; i <= n; i++) {
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
        }

        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (num[j][1] < num[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                }
            }
            max = Math.max(max, dp[i]); 
        }
        System.out.println(n - max); 
    }
}