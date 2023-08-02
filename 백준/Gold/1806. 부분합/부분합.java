import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int sum = 0;
        int answer = 987654321;
        int[] arr = new int[N];
        for(int end=0;end<N;end++){
            int num = Integer.parseInt(st.nextToken());
            arr[end] = num;
            sum += num;
            if(sum >= S){
                while(sum >= S){
                    answer = Math.min(answer, end - start);
                    sum -= arr[start++];
                }
            }
        }
        if(answer == 987654321)
            System.out.println(0);
        else
            System.out.println(answer+1);
    }
}