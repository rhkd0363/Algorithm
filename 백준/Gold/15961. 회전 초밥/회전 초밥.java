import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N + k + 1], check = new int[d + 1];
        for (int i = 1; i <= N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N + 1; i <= N + k; i++) {
            sushi[i] = sushi[i - N];
        }
        int start = 1, end = 1, answer = 0, count = 1;
        check[c] = 1;
        while (start <= N) {
            if (start == end - k) {
                if (--check[sushi[start]] == 0)
                    count--;
                start++;
            } else {
                if (check[sushi[end]]++ == 0)
                    count++;
                end++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}