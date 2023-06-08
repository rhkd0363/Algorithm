import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] cArr = new char[7][1];

		int[][] dxdy_1 = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
		int[][] dxdy_2 = { { -2, 0 }, { 0, -2 }, { 0, 2 }, { 2, 0 } };

		int result = 0;

		for (int i = 0; i < 7; i++) {
			String inputLine = br.readLine();
			cArr[i] = inputLine.toCharArray();
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < cArr[i].length; j++) {
				if (cArr[i][j] == '.') {
					for (int k = 0; k < 4; k++) {
						int x_1 = i + dxdy_1[k][0];
						int y_1 = j + dxdy_1[k][1];
						int x_2 = i + dxdy_2[k][0];
						int y_2 = j + dxdy_2[k][1];

						if (x_1 < 0 || x_1 >= 7 || y_1 < 0 || y_1 >= cArr[i].length || x_2 < 0 || x_2 >= 7 || y_2 < 0
								|| y_2 >= cArr[i].length)
							continue;

						char c_1 = cArr[x_1][y_1];
						char c_2 = cArr[x_2][y_2];

						if (c_1 == 'o' && c_2 == 'o')
							result++;
					}
				}
			}
		}

		System.out.println(result);
	}
}
