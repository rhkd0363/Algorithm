import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 2];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] += Integer.parseInt(st.nextToken());
            arr[i + 1] += arr[i];
        }

        int res = 0;
        int start = 0;
        int end = arr[N + 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            int prev = 0;
            for (int j = 1; j < N + 2; j++) {
                if (arr[j] - prev >= mid) {
                    count++;
                    prev = arr[j];
                }
            }
            if (count >= K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}