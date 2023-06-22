// 런타임에러 난다.. DFS로 해보고 싶었다..

import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer>[] list;
    
    public int solution(int n, int[][] results) {
        int[][] arr = new int[n+1][n+1];
            
        list = new HashSet[n+1];
        
        for(int i=1;i<n+1;i++)
            list[i] = new HashSet<>();
        
        for(int i=0;i<results.length;i++)
            list[results[i][1]].add(results[i][0]);
        
        visited = new boolean[n+1];
        
        for(int i=1;i<n+1;i++){
            visited[i] = true;   
            for(int j : list[i]){
                list[i].addAll(DFS(j));
            }
        }
        
        int[] rank = new int[n];
        
        for(int i=1;i<n+1;i++){
            rank[list[i].size()]++;
        }
              
        int answer = 0;
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum += rank[i];
            if(rank[i] == 1 && sum == i+1){
                answer++;
            }
        }
        
        return answer;
    }
    
    static Set<Integer> DFS(int idx){
        if(visited[idx])
            return list[idx];
        
        visited[idx] = true;
        
        if(list[idx].size() == 0)
            return list[idx];
        
        for(int i : list[idx]){
            list[idx].addAll(DFS(i));
        }
        
        return list[idx];
    }
}
