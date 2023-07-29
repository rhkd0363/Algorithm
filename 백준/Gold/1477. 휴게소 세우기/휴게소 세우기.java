import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        Integer[] restArea = new Integer[N];
        List<Integer> distance = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            restArea[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(restArea, Collections.reverseOrder());

        if(N != 0) {
            distance.add(L - restArea[0]);
            for (int i = 1; i < N; i++) {
                distance.add(restArea[i - 1] - restArea[i]);
            }
            distance.add(restArea[N - 1]);
        }else{
            distance.add(L - 0);
        }
        Collections.sort(distance);
        int end = distance.get(distance.size() - 1);

        int start = 1;
        while(start<=end){
            int mid = (start + end) / 2;

            int count = 0;

            for(int i : distance){
                count += (i-1) / mid;
            }

            if(count > M){
                start = mid + 1;

            }else
                end = mid - 1;

        }

        System.out.println(start);

    }
}