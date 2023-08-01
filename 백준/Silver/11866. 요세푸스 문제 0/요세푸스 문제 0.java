import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());
       Queue<Integer> queue = new LinkedList<>();
       for(int i=1;i<=N;i++)
           queue.add(i);
       StringBuilder sb = new StringBuilder();
       sb.append('<');
       while(!queue.isEmpty()){
           for(int i=1;i<K;i++)
               queue.add(queue.poll());
           sb.append(queue.poll()+", ");
       }
        System.out.println(sb.delete(sb.length()-2, sb.length()).append('>'));
    }
}