import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int last = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.offer(num);
                    last = num;
                    break;
                case "front":
                    sb.append(queue.size() != 0 ? queue.peek() : -1).append('\n');
                    break;
                case "back":
                    sb.append(queue.size() != 0 ? last : -1).append('\n');
                    break;
                case "pop":
                    sb.append(queue.size() != 0 ? queue.poll() : -1).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                default:
                    sb.append(queue.size()).append('\n');
            }
        }
        System.out.println(sb);
    }
}