import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            int[] count = new int[10];
            for (int i = 0; i < N; i++) {
                int input = Integer.parseInt(st.nextToken());
                arr[i] = input;
                count[input]++;
                queue.add(new int[]{input, i});
            }

            int answer = 0;

            for (int i = 9; i > arr[M]; i--) {
                while (count[i] > 0) {
                    int[] curr = queue.poll();


                    if (curr[0] == i) {
                        answer++;
                        count[i]--;
                    } else
                        queue.add(curr);
                }
            }

            while(!queue.isEmpty()){
                int[] curr = queue.poll();
                if(curr[0] == arr[M]){
                    if(curr[1] == M){
                        System.out.println(answer+1);
                        break;
                    }else{
                        answer++;
                    }
                }else{
                    queue.add(curr);
                }
            }
        }
    }
}