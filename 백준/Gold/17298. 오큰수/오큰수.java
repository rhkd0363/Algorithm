import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] list = new int[N];
        for(int i=0;i<N;i++)
            list[i] = Integer.parseInt(st.nextToken());

        for(int i=N-1;i>=0;i--){
            int num = list[i];

            while(true){
                if(stack.isEmpty()){
                    stack.push(num);
                    list[i] = -1;
                    break;
                }else{
                    if(stack.peek() > num){
                        list[i] = stack.peek();
                        stack.push(num);
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i:list)
            sb.append(i+" ");

        System.out.println(sb);
    }
}