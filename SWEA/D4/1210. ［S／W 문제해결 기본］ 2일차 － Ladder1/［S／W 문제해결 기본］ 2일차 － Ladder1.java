import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class  Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][102];
			List<Integer> iList = new ArrayList<>();
			int endPoint = 0;

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < 101; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2)
						endPoint = j;
					else if (arr[i][j] == 1 && i == 0)
						iList.add(j);
				}
			}

			int x = 99, y = endPoint;

			while (x > 0) {
				if (arr[x][y - 1] == 1) {
					y = iList.get(iList.indexOf(y) - 1);
				} else if (arr[x][y + 1] == 1) {
					y = iList.get(iList.indexOf(y) + 1);
				}
				x--;
			}
			
			System.out.println("#" + t + " " + (y-1));
		}
	}
}
