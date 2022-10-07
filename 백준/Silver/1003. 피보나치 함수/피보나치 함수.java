import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] fibo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		fibo = new int[41][2];
		fibo[0][0] = 1;	fibo[0][1] = 0;
		fibo[1][0] = 0;	fibo[1][1] = 1;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(getResult(N, 0)).append(' ').append(getResult(N, 1)).append('\n');
		}

		System.out.println(sb);
	}

	static int getResult(int num, int idx) {
		if(num == 0 || num == 1)
			return fibo[num][idx];
		
		if (fibo[num][idx] == 0) {
			fibo[num][0] = getResult(num - 1, 0) + getResult(num - 2, 0);
			fibo[num][1] = getResult(num - 1, 1) + getResult(num - 2, 1);
		}

		return fibo[num][idx];
	}
}