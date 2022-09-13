import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 색종이가 놓이는 평면 가로 1001칸,세로1001칸
		int[][] map = new int[1002][1002];

		int N = Integer.parseInt(br.readLine());

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + w; i++) {
				for (int j = y; j < y + h; j++) {
					map[i][j] = n;
				}
			}
		}

		for (int n = 1; n <= N; n++) {
			int cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j]==n) cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}