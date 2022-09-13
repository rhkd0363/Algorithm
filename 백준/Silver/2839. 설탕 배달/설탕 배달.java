import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int res = -1;
		// 11 1
		for (int i = 0; 5 * i <= n; i++) {
			int m = n - (5 * i); //6
			for (int j = 0; 3 * j <= m; j++) {
				if (m -(3*j) == 0) { 
					res = i + j;
				}

			}
		}

		System.out.println(res);
	}
}