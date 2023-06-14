import java.io.*;
import java.util.*; 

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long[][] map = new long[m+1][n+1];
        
        long num = 1000000007;
        
        map[1][1] = 1;
        
        for(int i=0;i<puddles.length;i++){
            map[puddles[i][0]][puddles[i][1]] = -1;
        }
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(map[i][j] == -1) continue;
                if(map[i-1][j] > 0)
                    map[i][j] = (map[i][j] +map[i-1][j]) % num;
                if(map[i][j-1] > 0)
                    map[i][j] = (map[i][j] + map[i][j-1]) % num;
            }
        }
        
        return (int) (map[m][n]);
    }
}