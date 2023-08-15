import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] list = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        long[] answer = new long[]{0, 0, 0, 10_000_000_001L};

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 2; j < N; j++) {
                long[] result = BinarySearch(i, j, list);
                if (result[3] == 0) {
                    answer = result;
                    break;
                }
                if (Math.abs(result[3]) < Math.abs(answer[3])) {
                    answer = result;
                }
            }
        }
        System.out.println(list[(int) answer[0]] + " " + list[(int) answer[1]] + " " + list[(int) answer[2]]);
    }

    static long[] BinarySearch(int start, int end, long[] list) {
        long[] result = new long[]{start, 0, end, 10_000_000_001L};
        long startValue = list[start];
        long endValue = list[end];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (startValue + endValue + list[mid] < 0) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }

            if (result[0] == mid || result[2] == mid)
                continue;

            if (startValue + endValue + list[mid] == 0) {
                result[1] = mid;
                result[3] = 0;
                return result;
            }

            if (Math.abs(startValue + endValue + list[mid]) < Math.abs(result[3])) {
                result[1] = mid;
                result[3] = startValue + endValue + list[mid];
            }
        }
        return result;
    }
}