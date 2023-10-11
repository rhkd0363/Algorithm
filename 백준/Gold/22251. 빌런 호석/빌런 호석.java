import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[][] display = {
                {1, 1, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 0, 1, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1},
        };
        int[][] diff = new int[10][10];
        for(int i=0;i<10;i++){
            for(int j=i+1;j<10;j++){
                int count = 0;
                for(int k=0;k<7;k++) {
                    if (display[i][k] != display[j][k])
                        count++;
                }
                diff[i][j] = count;
                diff[j][i] = count;
            }
        }
        int[] floor = new int[K];
        int curr = X;
        for(int i=K-1;i>=0;i--){
            floor[i] = X % 10;
            X /= 10;
        }
        System.out.println(dfs(0,P,floor,0,diff,0, N, K - 1, curr));
    }

    static int dfs(int num, int P, int[] floor, int index, int[][] diff, int currFloor, int N, int K, int X){
        if(num > P)
            return 0;
        if(index > K){
            if(currFloor == X || currFloor == 0)
                return 0;
            return 1;
        }
        int answer = 0;
        for(int i=0;i<10;i++){
            int plusFloor = (int)(i * Math.pow(10, K - index));
            if(currFloor + plusFloor > N)
                continue;
            answer += dfs(num + diff[floor[index]][i], P, floor, index + 1, diff, currFloor + plusFloor, N, K, X);
        }
        return answer;
    }
}