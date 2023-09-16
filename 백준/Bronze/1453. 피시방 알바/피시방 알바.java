import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] check = new boolean[101];
        int answer = 0;
        for(int i=0;i<N;i++){
            int number = Integer.parseInt(st.nextToken());
            if(check[number])
                answer++;
            else check[number] = true;
        }
        System.out.println(answer);
    }
}