import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] count = new int[100001];
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        int prev = -1;
        for(int i=0;i<N;i++){
            int number = Integer.parseInt(st.nextToken());
            list[i] = number;
            if(count[number] == K){
                do{
                    prev++;
                    count[list[prev]]--;
                }
                while(list[prev] != number);
            }
            count[number]++;
            answer = Math.max(answer, i - prev);
        }
        System.out.println(answer);
    }
}