import java.io.*;
import java.util.*;

public class Main{
    static class Node implements Comparable<Node>{
        int end, weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq= new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        long[] weights = new long[N+1];
        Arrays.fill(weights, Long.MAX_VALUE);
        List<Node>[] adjList = new ArrayList[N+1];
        for(int i=1;i<=N;i++)
            adjList[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end, weight));
            adjList[end].add(new Node(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(curr.end == end){
                System.out.println(weights[curr.end]);
                return;
            }
            if(visited[curr.end])
                continue;
            visited[curr.end] = true;

            for(Node node : adjList[curr.end]){
                if(!visited[node.end] && weights[node.end] > node.weight + curr.weight){
                    weights[node.end] = node.weight + curr.weight;
                    pq.add(new Node(node.end, node.weight + curr.weight));
                }
            }
        }
    }
}