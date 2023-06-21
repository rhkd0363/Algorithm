import java.util.*;

class Solution {
    static int answer;
    public int solution(int x, int y, int n) {
        
        answer = Integer.MAX_VALUE;
        
        boolean[] visited = new boolean[1000001];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        pq.add(new int[] {x, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            if(curr[0] > y)
                continue;
            
            
            if(curr[0] == y){
                answer = curr[1];
                break;
            }
            
            if(visited[curr[0]])
                continue;
            
            visited[curr[0]] = true;
            
            pq.add(new int[] {curr[0] * 2, curr[1] + 1});
            pq.add(new int[] {curr[0] * 3, curr[1] + 1});
            pq.add(new int[] {curr[0] + n, curr[1] + 1});
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}