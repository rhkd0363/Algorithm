import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int length = number.length() - k; 
        
        int pos = -1;
        
        String answer = "";
        
        while(true){
            if(length == 0)
                break;
            
            
            for(int i=9;i>=0;i--){
                String substr = number.substring(pos+1, number.length()-length+1);
                int idx = substr.indexOf(""+i);
                if(idx != -1){
                    pos += idx+1; 
                    answer += substr.charAt(idx);
                    break;
                }
            }
            
            
            // answer += numbers[length];
            length--;
        }
        
        return answer;
    }
}