import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[][] sArr = new String[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sArr[i][j] = st.nextToken();
				}
			}
			waterDepth(sArr, t);
		}
	}

	static void waterDepth(String[][] arr, int t) {
		int[][] dxdy = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		int max = 0;
		
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr.length; y++) {
				int cnt = 0;
				if(arr[x][y].equals("G")) continue;
				for (int i = 0; i < dxdy.length; i++) {
					int nx = x + dxdy[i][0];
					int ny = y + dxdy[i][1];
					if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
						continue;
					if (arr[nx][ny].equals("W"))
						cnt++;
				}
				if(cnt>max) max = cnt;
			}
		}

		if (max == 0)
			System.out.println("#" + t + " 1");
		else
			System.out.println("#" + t + " " + max);
	}
}
