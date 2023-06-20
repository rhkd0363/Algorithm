import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String inputLine = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = inputLine.charAt(j);

				if (map[i][j] == 'X')
					queue.add(new int[] { i, j });
			}
		}

		int[][] drdc = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
		int size = queue.size();

		for (int i = 0; i < size; i++) {
			int[] currPos = queue.poll();

			int count = 0;
			for (int j = 0; j < 4; j++) {
				int nr = currPos[0] + drdc[j][0];
				int nc = currPos[1] + drdc[j][1];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == '.')
					count++;
			}

			if (count >= 3)
				queue.add(currPos);
		}

		while (!queue.isEmpty()) {
			int[] currPos = queue.poll();

			map[currPos[0]][currPos[1]] = '.';
		}

		int minSide = 11, minLine = 11;
		int maxSide = -1, maxLine = -1;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X') {
					minSide = Math.min(minSide, j);
					maxSide = Math.max(maxSide, j);
					minLine = Math.min(minLine, i);
					maxLine = Math.max(maxLine, i);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = minLine; i <= maxLine; i++) {
			for (int j = minSide; j <= maxSide; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}