import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]>[] adjList = new ArrayList[N+1];
        for(int i=1;i<=N;i++)
            adjList[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cow = Integer.parseInt(st.nextToken());

            adjList[a].add(new int[]{b,cow});
            adjList[b].add(new int[]{a,cow});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        boolean[] visited = new boolean[N+1];
        int[] count = new int[N+1];
        Arrays.fill(count,Integer.MAX_VALUE);
        pq.add(new int[]{1,0});
        count[1] = 0;
        while (!pq.isEmpty()){
            int[] curr = pq.poll();

            if(curr[0] == N)
                break;

            visited[curr[0]] = true;

            for(int[] node : adjList[curr[0]]){
                if(!visited[node[0]] && count[node[0]] > node[1] + count[curr[0]]){
                    count[node[0]] = node[1] + count[curr[0]];
                    pq.add(new int[]{node[0],count[node[0]]});
                }
            }
        }
        System.out.println(count[N]);
    }
}