import java.io.*;
import java.util.*;

public class Main {
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] building = new int[N];
        Arrays.fill(building,1);

        if(N + 1 < a + b){
            System.out.println(-1);
            return;
        }

        int maxIdx = -1;

        int max = Math.max(a,b);
        if(a != 1){
            maxIdx = N - 1 - (b - 1);
        }else{
            maxIdx = 0;
        }

        for(int i=a, j = 0;i>=1;i--,j++){
            try{
                building[maxIdx - j] = i;
            }catch (IndexOutOfBoundsException e){
                System.out.println(-1);
                return;
            }
        }

        for(int i=1, j=N-1; i<b;i++,j--){
            try{
                if(building[j] > i || j < maxIdx){
                    System.out.println(-1);
                    return;
                }
                building[j] = i;
            }catch (IndexOutOfBoundsException e){
                System.out.println(-1);
                return;
            }
        }

        building[maxIdx] = max;

        StringBuilder sb = new StringBuilder();
        for(int num : building)
            sb.append(num + " ");
        System.out.println(sb);
    }
}