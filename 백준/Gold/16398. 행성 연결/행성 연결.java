import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int end;
        int cost;

        public Node(int end, int weight) {
            this.end = end;
            this.cost = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Node> pq= new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        List<Node>[] list = new ArrayList[N+1];
        for(int i=1;i<=N;i++)
            list[i] = new ArrayList<>();
        for(int i=1;i<=N;i++){
           st= new StringTokenizer(br.readLine());
           for(int j=1;j<=N;j++){
               int cost = Integer.parseInt(st.nextToken());
               list[i].add(new Node(j, cost));
               list[j].add(new Node(i, cost));
           }
        }
        boolean[] visited = new boolean[N+1];
        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        pq.add(new Node(1,0));
        cost[0] = 0;
        cost[1] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(visited[curr.end])
                continue;

            visited[curr.end] = true;

            for(Node node : list[curr.end]){
                if(!visited[node.end] && cost[node.end] > node.cost){
                    cost[node.end] = node.cost;
                    pq.add(node);
                }
            }
        }

        long answer = 0;
        for(int c : cost){
            answer += c;
        }

        System.out.println(answer);
    }
}
