import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] memo = new int[1000001];
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        for (int i = 0; i < N; i++)
            getResult(arr[i], memo, set);

        StringBuilder sb = new StringBuilder();
        for (int num : arr)
            sb.append(memo[num]).append(' ');

        System.out.println(sb);
    }

    static void getResult(int num, int[] memo, Set<Integer> set) {
        if (num == 1)
            return;

        memo[1]++;
        if (set.contains(1))
            memo[num]--;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                memo[i]++;
                if (set.contains(i))
                    memo[num]--;
                if (num / i != i) {
                    memo[num / i]++;
                    if (set.contains(num / i))
                        memo[num]--;
                }
            }
        }
    }
}