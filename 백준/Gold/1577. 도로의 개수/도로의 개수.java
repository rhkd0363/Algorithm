import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] map = new long[N+1][M+1];

        int k = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) * 100;
            int b = Integer.parseInt(st.nextToken())* 100;
            int c = Integer.parseInt(st.nextToken())* 100;
            int d = Integer.parseInt(st.nextToken())* 100;

            if (a > c) {
                set.add(c + "" + d + "" + a + "" + b);
            }

            if (a < c) {
                set.add(a + "" + b + "" + c + "" + d);
            }

            if (b > d) {
                set.add(c + "" + d + "" + a + "" + b);
            }

            if (b < d) {
                set.add(a + "" + b + "" + c + "" + d);
            }
        }

        map[N][M] = 1;

        for (int i = N; i >= 0; i--) {
            for (int j = M; j >= 0; j--) {
                if (i != 0 && !set.contains((i - 1)* 100 + "" + j* 100 + "" + i* 100 + "" + j* 100))
                    map[i - 1][j] += map[i][j];
                if (j != 0 && !set.contains(i* 100 + "" + (j - 1)* 100 + "" + i* 100 + "" + j* 100))
                    map[i][j - 1] += map[i][j];
            }
        }

        System.out.println(map[0][0]);
    }
}