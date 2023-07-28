import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek() > y){
                    stack.pop();
                    answer++;
                }else if(stack.peek() == y){
                    stack.pop();
                }else{
                    break;
                }
            }
            stack.push(y);
        }
        while(!stack.isEmpty()){
            if(stack.pop() != 0)
                answer++;
        }
        System.out.println(answer);
    }
}