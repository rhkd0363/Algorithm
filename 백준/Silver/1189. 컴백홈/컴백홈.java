import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];

        for(int i=0; i< R; i++)
            map[i] = br.readLine().toCharArray();

        int[][] dxdy = {{-1,0},{1,0},{0,-1},{0,1}};

        boolean[][] visited = new boolean[R][C];

        visited[R-1][0] = true;

        System.out.println(dfs(R-1, 0, map, visited, dxdy, K, 1));
    }

    static int dfs(int x, int y, char[][] map, boolean[][] visited, int[][] dxdy, int K, int count){
        if(count == K){
            if(x == 0 && y == map[0].length-1)
                return 1;
            else
                return 0;
        }
        int result = 0;
        
        for(int i=0;i<4;i++){
            int nx = x + dxdy[i][0];
            int ny = y + dxdy[i][1];

            if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
                continue;

            if(map[nx][ny] == 'T' || visited[nx][ny])
                continue;

            visited[nx][ny] = true;

            result += dfs(nx, ny, map, visited, dxdy, K, count+1);

            visited[nx][ny] = false;
        }
        return result;
    }
}
