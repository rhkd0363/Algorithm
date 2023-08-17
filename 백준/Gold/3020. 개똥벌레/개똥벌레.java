import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] bottom = new int[H+2];
        int[] top = new int[H+2];
        for(int i=0;i<N;i++){
            int height = Integer.parseInt(br.readLine());
            if(i%2 ==0)
                bottom[height]++;
            else
                top[H - height +1]++;
        }
        for(int i=1;i<top.length;i++){
            top[i] += top[i-1];
            bottom[bottom.length - 1 - i] += bottom[bottom.length - i];
        }
        int[] answer = new int[N+1];
        int min = 987654321;
        for(int i=1;i<top.length-1;i++){
            answer[top[i]+bottom[i]]++;
            min = Math.min(min, top[i]+bottom[i]);
        }
        System.out.println(min+" "+answer[min]);
    }
}