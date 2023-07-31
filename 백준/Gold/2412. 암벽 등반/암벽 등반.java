import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int x, y, count;
        boolean visit;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.visit = false;
            this.count = 0;
        }

        @Override
        public int compareTo(Node o) {
            if(this.count == o.count)
                return this.y - o.y;
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());

        List<Node>[] adjList = new ArrayList[T+1];

        for(int i=0;i<T+1;i++)
            adjList[i] = new ArrayList<>();

        int max_x = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            max_x = Math.max(max_x, x);

            adjList[y].add(new Node(x,y));
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0));

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            if(curr.y == T){
                System.out.println(curr.count);
                return;
            }

            for(int i=-2;i<=2;i++){
                int ny = curr.y + i;
                if(ny < 0 || ny > T)
                    continue;

                for(Node node : adjList[ny]){
                    if(node.visit || node.x < curr.x - 2 || node.x > curr.x + 2)
                        continue;
                    node.visit = true;
                    node.count = curr.count + 1;
                    queue.add(node);
                }
            }
        }
        System.out.println(-1);
    }
}