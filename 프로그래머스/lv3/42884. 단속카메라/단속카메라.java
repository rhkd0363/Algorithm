import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]){
                    return (a[0]+30000) - (b[0]+30000);
                }
                return (a[1]+30000) - (b[1]+30000);
            }
        });
        
        int min = -30001;
        
        int answer = 0;
        
        for(int i=0;i<routes.length;i++){
            if(min < routes[i][0]){
                min = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}