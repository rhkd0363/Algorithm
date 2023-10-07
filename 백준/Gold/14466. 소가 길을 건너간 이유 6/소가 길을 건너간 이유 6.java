import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        boolean[][][] way = new boolean[N+1][N+1][4];
        int[][] map = new int[N+1][N+1];

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());

            int x_1 = Integer.parseInt(st.nextToken());
            int y_1 = Integer.parseInt(st.nextToken());
            int x_2 = Integer.parseInt(st.nextToken());
            int y_2 = Integer.parseInt(st.nextToken());

            if(x_1 == x_2){
                if(y_1 > y_2){
                    way[x_1][y_1][3] = true;
                    way[x_2][y_2][1] = true;
                }else{
                    way[x_1][y_1][1] = true;
                    way[x_2][y_2][3] = true;
                }
            }else{
                if(x_1 > x_2){
                    way[x_1][y_1][0] = true;
                    way[x_2][y_2][2] = true;
                }else{
                    way[x_1][y_1][2] = true;
                    way[x_2][y_2][0] = true;
                }
            }
        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 2;
        }
        int[][] dxdy = {{-1,0},{0,1},{1,0},{0,-1}};
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(map[i][j] == 1)
                    continue;
                int count = 0;

                if(map[i][j] == 2)
                    count++;
                map[i][j] = 1;
                queue.add(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int x = curr[0];
                    int y = curr[1];

                    for (int k = 0; k < 4; k++) {
                        if (way[x][y][k])
                            continue;
                        int nx = x + dxdy[k][0];
                        int ny = y + dxdy[k][1];
                        if (nx <= 0 || ny <= 0 || nx > N || ny > N || map[nx][ny] == 1)
                            continue;
                        if (map[nx][ny] == 2)
                            count++;
                        map[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
                if (count != 0)
                    result += count * (K - count);
            }
        }
        System.out.println(result/2);
    }
}