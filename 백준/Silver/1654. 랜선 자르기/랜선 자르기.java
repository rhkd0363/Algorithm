import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cable = new int[N];

        long sum = 0;

        for(int i=0;i<N;i++){
            cable[i] = Integer.parseInt(br.readLine());
            sum += cable[i];
        }

        long start = 1;
        long end = sum / M;

        while(start <= end){
            long mid = (start + end) / 2;

            if(checkSize(mid, cable, M)){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }

        System.out.println(end);
    }

    static boolean checkSize(long num, int[] cable, int M){
        long count = 0;
        for(int i=0;i<cable.length;i++){
            count += cable[i]/num;
            if(count >= M){
                return true;
            }
        }
        return false;
    }
}