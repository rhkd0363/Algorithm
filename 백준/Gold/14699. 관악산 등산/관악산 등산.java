import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] height = new int[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            height[i] = Integer.parseInt(st.nextToken());
            pq.add(new int[]{i, height[i]});
        }

        List<Integer>[] adjList = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(height[start] > height[end])
                adjList[start].add(end);
            else
                adjList[end].add(start);
        }

        int[] answer = new int[N+1];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            for(int num : adjList[curr[0]]){
                answer[num] = Math.max(answer[num], answer[curr[0]] + 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i< answer.length;i++)
            sb.append(answer[i]+1).append('\n');

        System.out.println(sb);
    }
}