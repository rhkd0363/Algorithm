import java.io.*;
import java.util.*;

public class Main {
	static int N, count;
	static long result;
	static int[] arr;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		count = 0;
		result = -1;
		arr = new int[10];

		for (int i = 0; i < 10; i++) {
			dfs(10, i);
		}

		System.out.println(result);

	}

	// 9876543210 <- 제일 큰 줄어드는 수
	// 앞 자릿수의 숫자, 현재 숫자 자릿수
	static void dfs(int maxNum, int digit) {
		if (count == N)
			return;

		if (digit == 0) {
			for (int i = 0; i < maxNum; i++) {
				arr[digit] = i;
				count++;

				if (count == N) {
					long ans = 0;
					for (int j = 0; j < arr.length; j++) {
						ans += arr[j] * Math.pow(10, j);
					}
					result = ans;
					return;
				}
			}
			return;
		}

		for (int i = 0; i < maxNum; i++) {
			arr[digit] = i;
			dfs(i, digit - 1);
		}
	}
}
