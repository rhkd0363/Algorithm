import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[2][N];
        for(int i=0;i<N;i++){
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = arr[0][i];
        }

        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(arr[0][i] < arr[0][j]){
                    arr[1][j] = Math.max(arr[1][j], arr[1][i] + arr[0][j]);
                }
            }
            answer = Math.max(answer, arr[1][i]);
        }

        System.out.println(answer);
    }
}