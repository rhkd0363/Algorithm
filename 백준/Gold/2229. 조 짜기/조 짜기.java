import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        int[] max = new int[N+1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            int big = arr[i];
            int small = arr[i];
            int res = 0;
            for(int j=i;j>=0;j--){
                big = Math.max(big, arr[j]);
                small = Math.min(small, arr[j]);

                res = Math.max(res, big - small + max[j]);
            }
            max[i+1] = res;
        }

        System.out.println(max[N]);
    }
}