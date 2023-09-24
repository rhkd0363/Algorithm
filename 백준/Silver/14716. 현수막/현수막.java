import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int answer = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dxdy = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    answer++;
                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        
                        for(int k=0;k<8;k++){
                            int nx = curr[0] + dxdy[k][0];
                            int ny = curr[1] + dxdy[k][1];

                            if(nx < 0 || ny < 0 || nx >=N || ny >= M)
                                continue;
                            if(map[nx][ny] == 0 || visited[nx][ny])
                                continue;

                            visited[nx][ny] = true;
                            queue.add(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}