import java.util.*;
import java.io.*;

public class Main {
    static long[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        time = new long[N];
        long max = 0;
        for(int i=0;i<N;i++){
            time[i] = Long.parseLong(br.readLine());
            max = Math.max(max, time[i]);
        }

        long start = 0;
        long end = max * M;

        while(start <= end){
            long mid = (start + end) / 2;
            if(M <= getValue(mid, M)){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        System.out.println(end + 1);
    }
    static Long getValue(long mid, long M){
        long sum = 0;
        for(long num : time){
            sum += mid / num;
            if(M < sum)
                return sum;
        }
        return sum;
    }
}
