import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[11];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<=10;i++){
            arr[i] = arr[i-1] * i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        System.out.println(arr[N]/(arr[N-K]*arr[K]));
    }
}