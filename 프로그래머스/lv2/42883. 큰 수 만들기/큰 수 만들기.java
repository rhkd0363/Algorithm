import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int length = number.length() - k; 
        int pos = -1;
        
        char[] answer = new char[length];

        while(true){
            if(length == 0)
                break;


            for(int i=9;i>=0;i--){
                String substr = number.substring(pos+1, number.length()-length+1);
                int idx = substr.indexOf(""+i);
                if(idx != -1){
                    pos += idx+1; 
                    answer[answer.length - length] = substr.charAt(idx);
                    break;
                }
            }

            length--;
        }

        return new String(answer);
    }
}