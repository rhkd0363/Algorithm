import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int end;
        int weight;
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(0);
            return;
        }

        List<Node>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            adjList[i] = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[start].add(new Node(end, weight));
            adjList[end].add(new Node(start, weight));
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        Node result = BFS(queue, adjList, n);
        result.weight = 0;
        queue.add(result);
        System.out.println(BFS(queue, adjList, n).weight);
    }

    static Node BFS(Queue<Node> queue, List<Node>[] adjList, int n) {
        boolean[] visited = new boolean[n + 1];
        Node result = new Node(0, 0);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (visited[curr.end])
                continue;
            if (result.weight < curr.weight) {
                result = curr;
            }
            visited[curr.end] = true;
            for (Node node : adjList[curr.end]) {
                queue.offer(new Node(node.end, node.weight + curr.weight));
            }
        }
        return result;
    }
}