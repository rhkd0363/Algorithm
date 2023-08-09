import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] time = new int[N+1];
            long[] answer = new long[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                time[i] = Integer.parseInt(st.nextToken());
                answer[i] = time[i];
            }
            int[] count = new int[N+1];
            List<Integer>[] adjList = new ArrayList[N+1];
            for(int i=1;i<=N;i++)
                adjList[i] = new ArrayList<>();
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adjList[start].add(end);
                count[end]++;
            }
            int dest = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for (int i=1;i<=N;i++)
                if(count[i] == 0)
                    queue.add(i);

            while(!queue.isEmpty()){
                int curr = queue.poll();

                for (int next : adjList[curr]){
                    count[next]--;
                    answer[next] = Math.max(answer[next], time[next]+answer[curr]);
                    if(count[next] == 0){
                        queue.add(next);
                    }
                }
            }

            System.out.println(answer[dest]);
        }
    }
}