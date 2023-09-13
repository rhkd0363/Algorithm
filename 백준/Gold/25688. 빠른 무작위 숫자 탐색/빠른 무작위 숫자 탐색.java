import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[5][5];
        int[][] rc = new int[7][2];
        int[][] count = new int[7][7];
        boolean[] check = new boolean[7];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        rc[0][0] = Integer.parseInt(st.nextToken());
        rc[0][1] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 7; i++)
            bfs(rc, map, count, i);

        int answer = getAnswer(0, count, 0, check, 0);

        if (answer == 987654321)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    static void bfs(int[][] rc, int[][] map, int[][] count, int idx) {
        boolean[][] visited = new boolean[5][5];
        int[][] drdc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rc[idx][0], rc[idx][1], 0});
        visited[rc[idx][0]][rc[idx][1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (map[curr[0]][curr[1]] != 0 && map[curr[0]][curr[1]] != -1) {
                rc[map[curr[0]][curr[1]]][0] = curr[0];
                rc[map[curr[0]][curr[1]]][1] = curr[1];
                count[idx][map[curr[0]][curr[1]]] = curr[2];
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + drdc[i][0];
                int nc = curr[1] + drdc[i][1];
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || map[nr][nc] == -1 || visited[nr][nc])
                    continue;
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, curr[2] + 1});
            }
        }
    }

    static int getAnswer(int num, int[][] count, int sum, boolean[] check, int checkCount) {
        if (checkCount == 6)
            return sum;

        int res = 987654321;
        for (int i = 1; i < 7; i++) {
            if (num != i && !check[i] && count[num][i] != 0) {
                check[i] = true;
                res = Math.min(res, getAnswer(i, count, sum + count[num][i], check, checkCount + 1));
                check[i] = false;
            }
        }
        return res;
    }
}