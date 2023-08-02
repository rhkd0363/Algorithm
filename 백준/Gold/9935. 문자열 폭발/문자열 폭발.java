import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray(); //입력
        String boomStr = br.readLine(); // 폭발문자열
        Stack<Character> stack = new Stack<>(); // 메인스택 (값 쌓을거임)
        Stack<Character> tempStack = new Stack<>();; // 폭탄문자열과 비교하기 위한 스택
        loop : for(int i=input.length-1;i>=0;i--){
            stack.add(input[i]);
            if(input[i] == boomStr.charAt(0) && stack.size() >= boomStr.length()){
                for(int j=0;j<boomStr.length();j++){
                    if(stack.peek() == boomStr.charAt(j)){
                        tempStack.add(stack.pop());
                    }else{
                        while(!tempStack.isEmpty())
                            stack.add(tempStack.pop());
                        continue loop;
                    }
                }
                tempStack.clear();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb.length() != 0 ? sb : "FRULA");
    }
}