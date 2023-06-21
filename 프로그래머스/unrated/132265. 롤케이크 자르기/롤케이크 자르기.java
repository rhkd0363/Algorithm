import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] countL = new int[10001];
        int[] countR = new int[10001];
        
        Set<Integer> setL = new HashSet<>();
        Set<Integer> setR = new HashSet<>();

        for(int j=0;j<topping.length;j++){
            countR[topping[j]]++;
            if(countR[topping[j]] == 1)
                setR.add(topping[j]);
        }
        
        for(int i=0;i<topping.length;i++){
            countL[topping[i]]++;
            countR[topping[i]]--;
            
            if(countL[topping[i]] == 1)
                setL.add(topping[i]);
            
            if(countR[topping[i]] == 0)
                setR.remove(topping[i]);
            
            if(setL.size() > setR.size())
                break;
            
            if(setL.size() == setR.size())
                answer++;
        }
                
        return answer;
    }
}