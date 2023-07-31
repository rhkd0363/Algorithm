import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] arr = new int[3];
        while(true){
            st = new StringTokenizer(br.readLine());
            arr[0] = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
            arr[1] = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
            arr[2] = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
                break;
            Arrays.sort(arr);
            if(arr[2] - arr[1] - arr[0] == 0)
                sb.append("right").append('\n');
            else
                sb.append("wrong").append('\n');
        }
        System.out.println(sb);
    }
}