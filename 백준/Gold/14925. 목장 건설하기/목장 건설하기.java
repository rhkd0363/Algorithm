import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                if (st.nextToken().equals("0")) {
                    map[i][j] = Math.min(map[i - 1][j], Math.min(map[i - 1][j - 1], map[i][j - 1])) + 1;
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}