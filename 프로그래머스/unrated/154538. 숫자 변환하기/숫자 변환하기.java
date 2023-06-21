import java.util.*;

class Solution {
    static int answer;
    public int solution(int x, int y, int n) {
        
        answer = Integer.MAX_VALUE;
        
        boolean[] visited = new boolean[1000001];
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {x, 0});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            if(curr[0] > y)
                continue;
            
            
            if(curr[0] == y){
                answer = curr[1];
                break;
            }
            
            if(visited[curr[0]])
                continue;
            
            visited[curr[0]] = true;
            
            queue.add(new int[] {curr[0] * 2, curr[1] + 1});
            queue.add(new int[] {curr[0] * 3, curr[1] + 1});
            queue.add(new int[] {curr[0] + n, curr[1] + 1});
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}