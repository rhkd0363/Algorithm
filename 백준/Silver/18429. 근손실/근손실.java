import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] kit = new int[N];
        boolean[] checked = new boolean[N];

        for(int i=0;i<N;i++){
            kit[i] = Integer.parseInt(st.nextToken());
        }

        int answer = getComb(kit, checked, N, K, 1, 0);

        System.out.println(answer);
    }

    static int getComb(int[] kit, boolean[] checked, int N, int K, int count, int sum){
        if(count == N){
            return 1;
        }

        int result = 0;

        for(int i=0;i<N;i++){
            if(checked[i] || count * K > sum + kit[i])
                continue;

            checked[i] = true;
            result += getComb(kit, checked, N, K, count+1, sum + kit[i]);
            checked[i] = false;
        }

        return result;
    }
}