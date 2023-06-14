import java.io.*;
import java.util.*;

class Solution {
    static int ans;
    static int[][] dungeon;
    public int solution(int k, int[][] dungeons) {
        ans = 0;
        
        boolean[] visited = new boolean[dungeons.length];
        dungeon = dungeons;
        
        DFS(k, 0, visited);
        
        return ans;
    }
    
    static void DFS(int k, int count, boolean[] visited){
        ans = Math.max(ans,count);
        
        for(int i=0;i<visited.length;i++){
            if(!visited[i] && dungeon[i][0] <= k){
                visited[i] = true;
                DFS(k-dungeon[i][1], count+1, visited);
                visited[i] = false;
            }
        }
    }
}