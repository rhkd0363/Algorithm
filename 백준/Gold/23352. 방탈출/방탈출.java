import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dxdy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    continue;

                for (boolean[] bArr : visited)
                    Arrays.fill(bArr, false);

                queue.add(new int[]{i, j, 0});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    if (max < curr[2]) {
                        max = curr[2];
                        answer = map[i][j] + map[curr[0]][curr[1]];
                    } else if (max == curr[2]) {
                        answer = Math.max(answer, map[i][j] + map[curr[0]][curr[1]]);
                    }
                    for (int k = 0; k < 4; k++) {
                        int nx = curr[0] + dxdy[k][0];
                        int ny = curr[1] + dxdy[k][1];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || visited[nx][ny])
                            continue;
                        queue.add(new int[]{nx, ny, curr[2] + 1});
                        visited[nx][ny] = true;
                    }
                }

            }
        }
        System.out.println(answer);
    }
}