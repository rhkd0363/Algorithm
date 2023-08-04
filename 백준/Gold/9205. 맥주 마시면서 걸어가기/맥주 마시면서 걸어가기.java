import java.io.*;
import java.util.*;

public class Main{
    static class Edge implements Comparable<Edge>{
        int index, x, y, dist;
        public Edge(int index, int x, int y){
            this.index = index;
            this.x = x;
            this.y = y;
            this.dist = (int)(Math.sqrt(Math.pow(x,2)+Math.pow(y,2))*10);
        }

        @Override
        public int compareTo(Edge o){
            return this.dist - o.dist;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[N+2];
            Edge[] list = new Edge[N+2];
            st = new StringTokenizer(br.readLine());
            list[0] = new Edge(0, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); // 집

            for(int i=1;i<=N;i++) {
                st = new StringTokenizer(br.readLine());
                list[i] = new Edge(i, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); // 편의점
            }

            st = new StringTokenizer(br.readLine());
            list[N+1] = new Edge(N+1, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); // 페스티벌

            PriorityQueue<Edge> pq= new PriorityQueue<>();

            pq.add(list[0]);

            while(!pq.isEmpty()){
                Edge curr = pq.poll();

                if(visited[curr.index])
                    continue;

                visited[curr.index] = true;

                for(Edge edge : list){
                    if(!visited[edge.index] &&  Math.abs(edge.x - curr.x)+Math.abs(edge.y - curr.y) <= 1000){
                        pq.add(edge);
                    }
                }
            }
            sb.append(visited[N+1] ? "happy" : "sad").append('\n');
        }
        System.out.print(sb);
    }
}