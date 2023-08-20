import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
        int[][] sumMap = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sumMap[i][j] = map[i][j] + sumMap[i-1][j] + sumMap[i][j-1] - sumMap[i-1][j-1];
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                for(int k=0;k<i;k++){
                    for(int l=0;l<j;l++){
                        answer = Math.max(answer,sumMap[i][j] - sumMap[k][j] - sumMap[i][l] + sumMap[k][l]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}