import java.io.*;
import java.util.*;

class Solution {
    static boolean[][] map;
    static int answer,N;
    
    public int solution(int n, int[][] wires) {
        N = n;
        map = new boolean[N][N];
        
        for(int i=0;i<wires.length;i++){
            map[wires[i][0]-1][wires[i][1]-1] = true;
            map[wires[i][1]-1][wires[i][0]-1] = true;
        }
            
        answer = Integer.MAX_VALUE;
        
        DFS(0,0,0);
        
        return answer;
    }
    
    
    static int DFS(int idx, int cnt, int from){
        for(int i=0;i<N;i++){
            if(map[idx][i] && i != from){
                
                cnt += DFS(i,1, idx);
            }
        }
        
        answer = Math.min(answer, Math.abs(N - cnt * 2));
        
        return cnt;
    }
    
}
