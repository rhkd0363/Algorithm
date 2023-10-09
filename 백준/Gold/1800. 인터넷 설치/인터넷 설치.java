import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Node>[] adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            adjList[i] = new ArrayList<>();

        int end = 0;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[prev].add(new Node(next, cost));
            adjList[next].add(new Node(prev, cost));

            end = Math.max(end, cost);
        }
        int[] cost = new int[N + 1];

        int start = 0;
        int answer = -1;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        while(start <= end){
            int mid = (start+end) / 2;

            Arrays.fill(cost, Integer.MAX_VALUE);
            cost[1] = 0;
            pq.add(new Node(1,0));

            while(!pq.isEmpty()){
                Node curr = pq.poll();

                for(Node node : adjList[curr.end]){
                    int count = curr.cost;

                    if(node.cost > mid)
                        count ++;

                    if(count < cost[node.end]){
                        cost[node.end] = count;
                        pq.add(new Node(node.end, count));
                    }
                }
            }

            if(cost[N] <= K){
                answer = mid;
                end = mid -1;
            }else{
                start = mid +1;
            }
        }

        System.out.println(answer);
    }
}