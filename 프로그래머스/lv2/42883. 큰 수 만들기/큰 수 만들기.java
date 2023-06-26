import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int length = number.length() - k;
        
        for(int i=0;i<number.length();i++){
            while(!stack.isEmpty() && number.charAt(i) > stack.peek() && k-- > 0){
                stack.pop();
            }

            stack.push(number.charAt(i));
        }
        
        String answer = "";
        
        int size = stack.size();
        
        for(int i=0;i<length;i++){
            answer += stack.get(i);
        }
        
        return answer;
    }
}