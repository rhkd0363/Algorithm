import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int[] dice = new int[7];

        int[][] dir = {{0,0}, {0,1},{0,-1},{-1,0},{1,0}};

        for(int i=0;i<K;i++){
            int command = Integer.parseInt(st.nextToken());
            int nx = x + dir[command][0];
            int ny = y + dir[command][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;

            int temp = dice[1];

            switch (command){
                case 1:
                    dice[1] = dice[4];
                    dice[4] = dice[6];
                    dice[6] = dice[3];
                    dice[3] = temp;
                    break;
                case 2:
                    dice[1] = dice[3];
                    dice[3] = dice[6];
                    dice[6] = dice[4];
                    dice[4] = temp;
                    break;
                case 3:
                    dice[1] = dice[5];
                    dice[5] = dice[6];
                    dice[6] = dice[2];
                    dice[2] = temp;
                    break;
                case 4:
                    dice[1] = dice[2];
                    dice[2] = dice[6];
                    dice[6] = dice[5];
                    dice[5] = temp;
                    break;
            }

            if(map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            }
            else{
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }

            x = nx; y = ny;

            sb.append(dice[1]).append('\n');
        }
        System.out.println(sb);
    }
}