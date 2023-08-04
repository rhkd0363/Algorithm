import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end, cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, cost));
            list[end].add(new Node(start, cost));
        }
        st = new StringTokenizer(br.readLine());
        int firstPoint = Integer.parseInt(st.nextToken());
        int secondPoint = Integer.parseInt(st.nextToken());

        int startToFirst = dijkstra(1, firstPoint, N, list);
        int firstToSecond = dijkstra(firstPoint, secondPoint, N, list);
        int secondToEnd = dijkstra(secondPoint, N, N, list);

        int fSum = startToFirst+firstToSecond+secondToEnd;

        int startToSecond = dijkstra(1, secondPoint, N, list);
        int secondToFirst = dijkstra(secondPoint, firstPoint, N, list);
        int firstToEnd = dijkstra(firstPoint, N, N, list);

        int sSum = startToSecond+secondToFirst+firstToEnd;

        System.out.println(Math.min(fSum, sSum));
    }

    static int dijkstra(int start, int end, int N, List<Node>[] list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N + 1];
        pq.add(new Node(start,0));
        costs[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if(curr.end == end)
                break;
            if(visited[curr.end])
                continue;
            visited[curr.end] = true;
            for (Node node : list[curr.end]) {
                if (!visited[node.end] && costs[node.end] > costs[curr.end] + node.cost) {
                    costs[node.end] = costs[curr.end] + node.cost;
                    pq.add(new Node(node.end, costs[node.end]));
                }
            }
        }
        if(costs[end] == Integer.MAX_VALUE){
            exit();
        }
        return  costs[end];
    }

    static void exit(){
        System.out.println(-1);
        System.exit(0);
    }
}