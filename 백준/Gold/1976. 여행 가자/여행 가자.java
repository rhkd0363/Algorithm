import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer>[] adjList = new ArrayList[N+1];
        for(int i=1;i<=N;i++)
            adjList[i] = new ArrayList<>();

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int flag = Integer.parseInt(st.nextToken());
                if(flag == 1)
                    adjList[i].add(j);
            }
        }
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        queue.add(Integer.parseInt(st.nextToken()));
        visited[queue.peek()] = true;

        while (!queue.isEmpty()){
            int curr = queue.poll();

            for(int node : adjList[curr]){
                if(!visited[node]){
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
        boolean answer = true;
        for(int i=1;i<M;i++){
            if(!visited[Integer.parseInt(st.nextToken())]){
                answer = false;
                break;
            }
        }
        System.out.println(answer ? "YES" : "NO");
    }
}