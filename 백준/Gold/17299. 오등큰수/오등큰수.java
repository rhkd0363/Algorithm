import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            map.put(num, map.get(num) != null ? map.get(num) + 1 : 1);
        }
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                if (map.get(arr[stack.peek()]) < map.get(arr[i])) {
                    answer[stack.pop()] = arr[i];
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int ans : answer)
            sb.append(ans).append(' ');

        System.out.println(sb);
    }
}