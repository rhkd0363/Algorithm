import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] range = new int[N];
        int min = 987654321;
        int max = 0;
        for (int i = 0; i < N; i++) {
            range[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, range[i]);
            min = Math.min(min, range[i]);
        }
        int start = 0;
        int end = max - min;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(mid, M, range)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
    static boolean check(int value, int M, int[] arr) {
        int min= 10001, max = 0;
        int d = 1;
        for(int i : arr){
            min = Math.min(min, i);
            max = Math.max(max, i);
            if(max - min > value){
                d++;
                min = i;
                max = i;
            }
        }
        return d <= M ? true : false;
    }
}