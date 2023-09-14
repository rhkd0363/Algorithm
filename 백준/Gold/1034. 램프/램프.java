import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] row = new String[N];
        for (int i = 0; i < N; i++) {
            row[i] = br.readLine();
        }
        int K = Integer.parseInt(br.readLine());
        int krt = K % 2;
        int answer = 0;
        boolean flag = false;
        for(int i=0;i<N;i++){
            int count = 0;

            for(int j=0;j<M;j++)
                count += row[i].charAt(j)-'0' == 0 ? 1 : 0;

            if(count%2 != krt)
                continue;

            int result = 1;
            for(int j = i+1; j< N;j++)
                result += row[i].equals(row[j]) ? 1 : 0;

            if(count <= K && result > answer){
                answer = result;
                flag = true;
            }
        }

        System.out.println(flag ? answer : 0);
    }
}