import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] paper = new int[101][101];

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					paper[j][k] = 1;
				}
			}
		}

		int result = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		for (int j = 0; j < paper.length; j++) {
			for (int k = 0; k < paper.length; k++) {
				if (paper[j][k] == 1) {
					int cnt = 0;
					for (int i = 0; i < 4; i++) {
						int nx = j + dx[i];
						int ny = k + dy[i];
						if (nx < 0 || ny < 0 || nx >= paper.length || ny >= paper.length)
							continue;
						if (paper[nx][ny] == 0) {
							cnt++;
						}
					}
					if(cnt == 1) result ++;
					else if(cnt > 1) result +=2;
				}
			}
		}
		System.out.println(result);
	}
}