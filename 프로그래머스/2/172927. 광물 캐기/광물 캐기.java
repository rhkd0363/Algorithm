import java.io.*;
import java.util.*;

class Solution {
    int answer;
    public int solution(int[] picks, String[] minerals) {
        answer = 987654321;
        int[][] arr = new int[(int)Math.ceil(minerals.length / 5.0)][3];
        
        for(int i=0;i<minerals.length;i++){
            int multiNum = i * 5;
            
            for(int j=0;j < 5 && j + multiNum < minerals.length;j++){
                switch(minerals[j + multiNum]){
                    case "diamond":
                        arr[i][0] += 1;
                        arr[i][1] += 5;
                        arr[i][2] += 25;
                        break;
                    case "iron":
                        arr[i][0] += 1;
                        arr[i][1] += 1;
                        arr[i][2] += 5;
                        break;
                    default :
                        arr[i][0] += 1;
                        arr[i][1] += 1;
                        arr[i][2] += 1;
                        break;
                }
            }
        }
        
        int pickCnt = 0;
        for(int cnt : picks)
            pickCnt += cnt;
        
        getComb(picks, arr, 0, pickCnt, 0);
        
        return answer;
    }
    
    public void getComb(int[] picks, int[][] arr, int index, int pickCnt, int fatigue){
        if(answer < fatigue)
            return;
            
        if(pickCnt == 0 || index == arr.length){
            answer = Math.min(answer, fatigue);
            return;
        }
        
        for(int i=0;i<3;i++){
            if(picks[i] > 0){
                picks[i]--;
                getComb(picks, arr, index + 1, pickCnt - 1, fatigue + arr[index][i]);
                picks[i]++;
            }
        }
    }
}