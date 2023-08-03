import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            List<Integer> answer = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                list.add(Integer.parseInt(st.nextToken()));

                if (i % 2 == 1) {
                    Collections.sort(list);
                    answer.add(list.get(i / 2));
                }

                if (i % 10 == 0 && i != M)
                    st = new StringTokenizer(br.readLine());
            }
            sb.append(answer.size());
            for(int i=0;i<answer.size();i++){
                if(i%10 == 0)
                    sb.append('\n');
                sb.append(answer.get(i)).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}