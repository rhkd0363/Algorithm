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
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || map[i][j] == 0)
                    continue;
                answer = Math.max(answer, BFS(map, visited, i, j));
                count++;
            }
        }
        System.out.println(count + "\n" + answer);
    }

    static int BFS(int[][] map, boolean[][] visited, int i, int j) {
        int[][] dxdy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 1});
        int result = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (visited[curr[0]][curr[1]]) continue;
            visited[curr[0]][curr[1]] = true;
            result++;
            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dxdy[k][0];
                int ny = curr[1] + dxdy[k][1];
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[i].length || visited[nx][ny] || map[nx][ny] == 0)
                    continue;
                queue.add(new int[]{nx, ny, curr[2] + 1});
            }
        }
        return result;
    }
}