import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] check = new int[N];
        Arrays.fill(check, 1_000_000_001);
        int max = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = i;
            while (start <= end) {
                int mid = (start + end) / 2;

                if (check[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            check[start] = num;
            max = Math.max(start, max);
        }

        System.out.println(max+1);
    }
}