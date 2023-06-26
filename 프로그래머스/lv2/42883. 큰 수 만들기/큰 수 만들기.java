import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<number.length();i++){
            while(!stack.isEmpty()){
                if(number.charAt(i) <= stack.peek() || k <= 0 ){
                    break;
                }
                
                k--;
                stack.pop();
            }

            stack.push(number.charAt(i));
        }
        
        String answer = "";
        
        int size = stack.size() - k;
        
        for(int i=0;i<size;i++){
            answer += stack.get(i);
        }
        
        return answer;
    }
}