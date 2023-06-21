import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] countL = new int[10001];
        int[] countR = new int[10001];
        
        int left = 0;
        int right = 0;

        for(int j=0;j<topping.length;j++){
            countR[topping[j]]++;
            if(countR[topping[j]] == 1)
                right++;
        }
        
        for(int i=0;i<topping.length;i++){
            countL[topping[i]]++;
            countR[topping[i]]--;
            
            if(countL[topping[i]] == 1)
                left++;
            
            if(countR[topping[i]] == 0)
                right--;
            
            if(left > right)
                break;
            
            if(left == right)
                answer++;
        }
                
        return answer;
    }
}