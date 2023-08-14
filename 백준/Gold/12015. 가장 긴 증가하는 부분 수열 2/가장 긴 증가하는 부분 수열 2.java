import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lis = new int[N+1];
        Arrays.fill(lis,987654321);
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        lis[0] = arr[0];

        int answer = 0;

        for(int i=1;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = i;
            while(start <= end){
                int mid = (start+end) / 2;
                if(lis[mid] < arr[i]){
                    start = mid+1;
                }else{
                    end = mid -1;
                }
            }
            lis[start] = arr[i];
            answer = Math.max(answer, start);
        }
        System.out.println(answer+1);
    }
}