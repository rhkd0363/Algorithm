import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] arr = new int[n+1][n+1];
        
        for(int i=0;i<results.length;i++){
            arr[results[i][0]][results[i][1]] = 1;
            arr[results[i][1]][results[i][0]] = -1;    
        }
        
        for(int i=1;i<n+1;i++){ // 경
            for(int j=1;j<n+1;j++){ // 출
                for(int k=1;k<n+1;k++){ // 도
                    if(i == j || j == k || i == k)
                        continue;
                    
                    if(arr[j][i] == 1 && arr[i][k] == 1){
                        arr[j][k] = 1;
                        arr[k][j] = -1;
                    }
                }
            }
        }
        
        int answer= 0;
        
        for(int i=1;i<n+1;i++){
            int count = 0; 
            for(int j=1;j<n+1;j++){
                if(arr[i][j] != 0)
                    count++;
            }
            if(count == n-1)
                answer++;
        }
                
        return answer;
    }
}