import java.io.*;
import java.util.*;

public class Main {
    static class Info implements Comparable<Info>{
        int x,y,count;
        public Info(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Info o){
            return this.count - o.count;
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

        boolean[][] visited = new boolean[N][M];

        Queue<Info> queue = new PriorityQueue<>();
        queue.add(new Info(0,0,0));
        visited[0][0] = true;
        int answer = 0;
        int[][] dxdy =  {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            Info curr = queue.poll();

            if(curr.x == N-1 && curr.y == M-1){
                answer = curr.count;
                break;
            }

            for(int i=0;i<4;i++){
                int nx = curr.x + dxdy[i][0];
                int ny = curr.y + dxdy[i][1];

                if(nx < 0 || ny < 0 || nx >=N || ny >=M || visited[nx][ny])
                    continue;

                visited[nx][ny] = true;
                queue.add(new Info(nx,ny, map[nx][ny] == 1 ? curr.count+1 : curr.count));
            }
        }
        System.out.println(answer);
    }
}