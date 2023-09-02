import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            double diff;
            prev:
            for (int j = 0; j < i; j++) {
                diff = (double) Math.abs(arr[i] - arr[j]) / Math.abs(i - j);
                for (int k = j + 1; k < i; k++) {
                    if (arr[i] > arr[j]) {
                        if (arr[j] + diff * (k - j) <= arr[k])
                            continue prev;
                    } else {
                        if (arr[j] - diff * (k - j) <= arr[k])
                            continue prev;
                    }
                }
                count++;
            }
            next:
            for (int j = i + 1; j < N; j++) {
                diff = (double) Math.abs(arr[j] - arr[i]) / Math.abs(j - i);
                for (int k = i + 1; k < j; k++) {
                    if (arr[i] > arr[j]) {
                        if (arr[i] - diff * (k - i) <= arr[k])
                            continue next;
                    }else{
                        if (arr[i] + diff * (k - i) <= arr[k])
                            continue next;
                    }
                }
                count++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}