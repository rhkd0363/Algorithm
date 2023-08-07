import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        long ans = 0;

        for(int i=0;i<N;i++){
            int building = Integer.parseInt(br.readLine());

            while(!stack.isEmpty()){
                if(stack.peek() > building){
                    break;
                }else{
                    stack.pop();
                    ans += stack.size();
                }
            }

            stack.push(building);
        }

       while(stack.size() > 1){
           int building = stack.pop();

           if(stack.peek() > building){
               ans += stack.size();
           }
       }

        System.out.println(ans);
    }
}