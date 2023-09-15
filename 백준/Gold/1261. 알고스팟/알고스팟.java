import java.io.*;
import java.util.*;

public class Main {
    static class Info{
        int x,y,count;
        public Info(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j) -'0';
            }
        }

        int[][] visited = new int[N][M];
        for(int i=0;i<N;i++)
            Arrays.fill(visited[i],987654321);

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0,0,0));

        int[][] dxdy =  {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            Info curr = queue.poll();

            for(int i=0;i<4;i++){
                int nx = curr.x + dxdy[i][0];
                int ny = curr.y + dxdy[i][1];

                if(nx < 0 || ny < 0 || nx >=N || ny >=M)
                    continue;

                Info next = new Info(nx,ny, map[nx][ny] == 1 ? curr.count+1 : curr.count);

                if(visited[nx][ny] <= next.count)
                    continue;

                visited[nx][ny] = next.count;
                queue.add(next);
            }
        }

        if(N == 1 && M == 1)
            System.out.println(0);
        else
            System.out.println(visited[N-1][M-1]);
    }
}