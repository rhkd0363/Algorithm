import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static int res;
//	static int[] res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
//		res = new int[N];
		res = 0;

		putQueen(0);
		
		System.out.println(res);
	}

	static void putQueen(int r) {
		if(r == N) {
//			StringBuilder sb = new StringBuilder();
//			for(int i=0;i<N;i++) {
//				sb.append(res[i]).append('\n');
//			}
//			System.out.print(sb);
//			System.exit(0);
			res++;
			return;
		}
		
		for(int c=0;c<N;c++) {
			if(checkQueen(r,c)) {
				map[r][c] = 1;
//				res[r] = c+1;
				putQueen(r+1);
				map[r][c] = 0;
//				res[r] = 0;
			}
		}
	}

	static boolean checkQueen(int r, int c) {
		int left = c - 1;
		int right = c + 1;
		
		for (int i = r - 1; i >= 0; i--) {
			if (map[i][c] == 1 || (right < N && map[i][right++] == 1)
					|| (left >= 0 &&map[i][left--] == 1))
				return false;
		}
		
		return true;
	}
}