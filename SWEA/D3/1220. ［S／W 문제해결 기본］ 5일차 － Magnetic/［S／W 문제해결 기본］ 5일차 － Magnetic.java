import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] table = new int[100][100];

			for (int i = 0; i < table.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < table.length; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 우선 테이블 범위 벗어나는거 확인하여 0으로 처리
			// 1은 위로 2는 아래로
			for (int j = 0; j < table.length; j++) {
				for (int i = 0; i < table.length; i++) {
					check = false;
					switch (table[i][j]) {
					case 0:
						break;
					case 1:
						checkOne(table, i, j);
						if (!check)
							table[i][j] = 0;
						break;
					case 2:
						checkTwo(table, i, j);
						if (!check)
							table[i][j] = 0;
						break;
					}
				}
			}
			int result = 0;
			for (int j = 0; j < table.length; j++) {
				int cnt = 0;
				for (int i = 0; i < table.length; i++) {
					if (table[i][j] == 1)
						cnt++;
				}
				result += cnt;
			}
			System.out.println("#"+t+" "+result);
		}
	}

	static boolean check;

	static void checkTwo(int[][] table, int i, int j) {
		if (i - 1 < 0 || i - 1 >= table.length)
			return;
		if (table[i - 1][j] == 2) {
			table[i - 1][j] = 0;
		}
		if (table[i - 1][j] == 1) {
			check = true;
			return;
		}
		checkTwo(table, i - 1, j);
	}

	static void checkOne(int[][] table, int i, int j) {
		if (i + 1 < 0 || i + 1 >= table.length)
			return;
		if (table[i + 1][j] == 1) {
			table[i + 1][j] = 0;
		}
		if (table[i + 1][j] == 2) {
			check = true;
			return;
		}
		checkOne(table, i + 1, j);
	}
}
