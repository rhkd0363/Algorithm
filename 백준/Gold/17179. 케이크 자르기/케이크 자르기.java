import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];

        for(int i=0;i<M;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int cut = Integer.parseInt(br.readLine());
            int res = 0;
            int start = 0;
            int end = L;
            while(start<=end){
                int mid = (start+end) / 2;
                int prev = 0;
                int count = 0;
                for(int j=0;j<M;j++){
                    if(arr[j] - prev >= mid){
                        prev = arr[j];
                        count++;
                    }
                }

                if(L - prev < mid){
                    count--;
                }

                if(count >= cut){
                    res = Math.max(res, mid);
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }
}