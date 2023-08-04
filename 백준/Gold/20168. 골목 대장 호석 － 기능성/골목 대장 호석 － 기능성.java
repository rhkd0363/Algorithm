import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end, cost, max;
        public Node(int end, int cost, int max) {
            this.end = end;
            this.cost = cost;
            this.max = max;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        List<Node>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, cost, cost));
            list[end].add(new Node(start, cost, cost));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(A, 0, 0));
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N+1];
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            visited[curr.end] = true;

            for (Node node : list[curr.end]) {
                if (!visited[node.end] && node.cost + curr.cost <= C) {
                    if(costs[node.end] <= node.max && costs[node.end] <= curr.max) continue;
                    Node temp = new Node(node.end, node.cost + curr.cost, Math.max(node.max, curr.max));
                    costs[node.end] = Math.min(costs[node.end], temp.max);
                    pq.add(temp);
                }
            }
        }
        System.out.println(costs[B] != Integer.MAX_VALUE ? costs[B] : -1);
    }
}